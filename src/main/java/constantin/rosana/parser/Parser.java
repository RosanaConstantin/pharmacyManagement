package constantin.rosana.parser;

import constantin.rosana.generated.Farmacie;
import constantin.rosana.generated.ObjectFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
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

        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        final XMLReader reader = saxParserFactory.newSAXParser().getXMLReader();
        reader.setEntityResolver(new EntityResolver() {

            @Override
            public InputSource resolveEntity(final String publicId, final String systemId) throws SAXException, IOException {

                return new InputSource(ClassLoader.getSystemResourceAsStream("files/farmacie.dtd"));
            }
        });
        final SAXSource saxSource = new SAXSource(reader, new InputSource(ClassLoader.getSystemResourceAsStream("files/" + fileName)));

        return (Farmacie) unmarshaller.unmarshal(saxSource);
    }
}
