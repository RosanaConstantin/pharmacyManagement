package constantin.rosana.parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
import java.io.File;
import java.io.IOException;

/**
 * Created by Rosana-Constantin on 22-Mar-18.
 */
@Service
public class Parser {
    /*public Farmacie parse(String filename){
        XmlMapper xmlMapper = new XmlMapper();
        Farmacie farmacie = new Farmacie();
        try {
            farmacie = xmlMapper.readValue(new File("C:\\Users\\ROSANA\\IdeaProjects\\pharmacymanagement\\src\\main\\resources\\files\\farmacie.xml"), Farmacie.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return farmacie;
    }*/

    public Farmacie parse(String fileName) throws Exception {
        //1. We need to create JAXContext instance
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

        //2. Use JAXBContext instance to create the Unmarshaller.
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

        //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
        return (Farmacie) unmarshaller.unmarshal(saxSource);
    }
}
