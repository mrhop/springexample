package com.hopever.springexample.integration.xml;

import org.springframework.xml.xpath.XPathExpression;
import org.w3c.dom.Document;


/**
 * Created by Donghui Huo on 2016/3/14.
 */
public class StockChecker {

    private final XPathExpression isbnSelectingXPath;

    public StockChecker(XPathExpression isbnSelectingXPath) {
        this.isbnSelectingXPath = isbnSelectingXPath;
    }

    public Document checkStockLevel(Document doc) {
        String isbn = isbnSelectingXPath.evaluateAsString(doc);
        boolean inStock = false;

        // we only carry stock of one book currently
        if ("0321200683".equals(isbn)) {
            inStock = true;
        }
        doc.getDocumentElement().setAttribute("in-stock", String.valueOf(inStock));
        return doc;
    }

//    public Object checkStockLevel1(Object doc) {
//        return doc;
//    }
}
