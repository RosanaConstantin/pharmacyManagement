package constantin.rosana.parser;


import constantin.rosana.generated.Farmacie;
import constantin.rosana.generated.ObjectFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Rosana-Constantin on 22-Mar-18.
 */
@Service
public class Parser {
    public Farmacie parse(String fileName) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        System.setProperty("javax.xml.accessExternalDTD", "all");

        /**
         * schema is created
         */
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/main/resources/files/farmacie.xsd"));
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new XMLErrorHandler());

        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        final XMLReader reader = saxParserFactory.newSAXParser().getXMLReader();
        reader.setEntityResolver(new EntityResolver() {

            @Override
            public InputSource resolveEntity(final String publicId, final String systemId) throws SAXException, IOException {

                return new InputSource(ClassLoader.getSystemResourceAsStream("files/farmacie.dtd"));
            }
        });
        final SAXSource saxSource = new SAXSource(reader, new InputSource(ClassLoader.getSystemResourceAsStream("files/" + fileName)));

        Farmacie farmacie = (Farmacie) unmarshaller.unmarshal(saxSource);
        JAXBSource farmacieSource = new JAXBSource(jaxbContext, farmacie);
        validator.validate(farmacieSource);
        return farmacie;
    }
}
