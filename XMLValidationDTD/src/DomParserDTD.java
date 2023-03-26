import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class DomParserDTD {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            // parse the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new XmlErrorHandler());
//            Document document = builder.parse(new File("C:\\Users\\niksb\\eclipse-workspace\\XMLValidationDTD\\src\\bookstore.xml"));
            Document document = builder.parse(new File("src/bookstore.xml"));

            System.out.println("The XML document is valid.");

        } catch (SAXParseException e) {
            System.err.println("Error on line " + e.getLineNumber() + ", column " + e.getColumnNumber() + ": " + e.getMessage());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XmlErrorHandler implements org.xml.sax.ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.err.println("Warning: " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.err.println("Error: " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("Fatal error: " + exception.getMessage());
    }
}
