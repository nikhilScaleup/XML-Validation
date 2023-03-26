import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class DomParserSchema {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            // parse the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(new File("C:\\Users\\niksb\\eclipse-workspace\\XMLValidationSchema\\src\\bookstore.xml"));
            Document document = builder.parse(new File("src/bookstore.xml"));

            // create a schema instance
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = schemaFactory.newSchema(new File("C:\\Users\\niksb\\eclipse-workspace\\XMLValidationSchema\\src\\bookstore.xsd"));
            Schema schema = schemaFactory.newSchema(new File("src/bookstore.xsd"));

            // validate the XML document against the schema
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));

            System.out.println("The XML document is valid.");

        } catch (SAXParseException e) {
            System.err.println("Error on line " + e.getLineNumber() + ", column " + e.getColumnNumber() + ": " + e.getMessage());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
