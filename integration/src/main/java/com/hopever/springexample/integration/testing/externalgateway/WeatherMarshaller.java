package com.hopever.springexample.integration.testing.externalgateway;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.MarshallingFailureException;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import org.springframework.xml.xpath.XPathExpressionFactory;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class WeatherMarshaller implements Marshaller, Unmarshaller, InitializingBean {
    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private Map<String, String> namespacePrefixes = new HashMap<String, String>();

    private String xpathPrefix = "/p:GetCityWeatherByZIPResponse/p:GetCityWeatherByZIPResult/";

    public Object unmarshal(Source source) throws IOException, XmlMappingException {

        //this.writeXml(((DOMSource)source).getNode().getOwnerDocument());
        DOMResult result = null;
        try {
            Transformer transformer = transformerFactory.newTransformer();
            result = new DOMResult();
            transformer.transform(source, result);
        } catch (Exception e) {
            throw new MarshallingFailureException("Failed to unmarshal SOAP Response", e);
        }
        Weather weather = new Weather();
        String expression = xpathPrefix + "p:City";
        String city = XPathExpressionFactory.createXPathExpression(expression, namespacePrefixes).evaluateAsString(result.getNode());
        weather.setCity(city);
        expression = xpathPrefix + "p:State";
        String state = XPathExpressionFactory.createXPathExpression(expression, namespacePrefixes).evaluateAsString(result.getNode());
        weather.setState(state);
        expression = xpathPrefix + "p:Temperature";
        String temperature = XPathExpressionFactory.createXPathExpression(expression, namespacePrefixes).evaluateAsString(result.getNode());
        weather.setTemperature(temperature);
        expression = xpathPrefix + "p:Description";
        String description = XPathExpressionFactory.createXPathExpression(expression, namespacePrefixes).evaluateAsString(result.getNode());
        weather.setDescription(description);
        return weather;
    }

    public boolean supports(Class<?> clazz) {
        System.out.println("Suppors");
        return false;
    }

    public void marshal(Object zip, Result result) throws IOException,
            XmlMappingException {
        String xmlString = "<weat:GetCityWeatherByZIP xmlns:weat=\"http://ws.cdyne.com/WeatherWS/\">" +
                "	<weat:ZIP>" + zip + "</weat:ZIP>" +
                "</weat:GetCityWeatherByZIP>";
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new StringSource(xmlString), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void writeXml(Document document) {
        Transformer transformer = createIndentingTransformer();

        transformer.setOutputProperty(OutputKeys.METHOD, "xml");

        try {
            StringResult streamResult = new StringResult();
            transformer.transform(new DOMSource(document), streamResult);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
    public static final Transformer createIndentingTransformer() {
        Transformer xformer;
        try {
            xformer = transformerFactory.newTransformer();
            xformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            xformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(2));
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        xformer.setOutputProperty(OutputKeys.INDENT, "yes");
        xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        return xformer;
    }

    public void afterPropertiesSet() throws Exception {
        namespacePrefixes.put("p", "http://ws.cdyne.com/WeatherWS/");
    }
}
