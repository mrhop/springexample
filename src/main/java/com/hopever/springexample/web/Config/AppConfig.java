package com.hopever.springexample.web.Config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/28.
 */

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
    /*@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(
                MediaType.TEXT_HTML);
    }

   @Bean
    public ViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(jspViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }

   @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/

    @Bean
    public HttpMessageConverters customConverters() {
        MarshallingHttpMessageConverter xmlConverter =
                new MarshallingHttpMessageConverter();

        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
        return new HttpMessageConverters(xmlConverter);
    }

    /*public class UserHttpMessageConverter extends AbstractHttpMessageConverter<User> {

        @Override
        protected boolean supports(Class<?> clazz) {
            if(clazz.getName().contains("User"))
                return true;
            return false;
        }

        @Override
        protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
            return new User("you know");
        }

        @Override
        protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
            user.setName(user.getName()+":finanlly");
        }


    }*/

    @Bean
    public WebBindingInitializer customerBinding() {
        return new CustomerBinding();
    }

    public class CustomerBinding extends ConfigurableWebBindingInitializer {

        @Override
        public void initBinder(WebDataBinder binder, WebRequest request) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            binder.registerCustomEditor(Date.class, new CustomDateEditor(
                    dateFormat, false));
        }
    }
}
