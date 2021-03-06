package constantin.rosana.app;

import constantin.rosana.generated.Farmacie;
import constantin.rosana.parser.Parser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rosana-Constantin on 18-Mar-18.
 */

@Controller
public class AppController {
    @Autowired
    private Parser parser;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

    @RequestMapping(value = "/parsed", method = RequestMethod.GET)
    public String getParsedFile(@RequestParam(name = "filename") String fileName, Model model) throws Exception {
        Farmacie farmacie = this.parser.parse(fileName);
        model.addAttribute("listaRetete", farmacie.getReteta());
        return "parsed";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public HttpEntity<byte[]> getXMLFile(@RequestParam(name = "filename") String fileName) throws Exception {
        HttpEntity<byte[]> response = getFile(fileName);
        if (response != null) {
            return response;
        } else {
            StringWriter writer = new StringWriter();
            IOUtils.copy(ClassLoader.getSystemResourceAsStream("templates/errorView.html"), writer, "UTF-8");
            String file = writer.toString();
            byte[] documentBody = file.getBytes();
            HttpHeaders header = new HttpHeaders();
            header.setContentLength(documentBody.length);
            return new HttpEntity<byte[]>(documentBody, header);
        }
    }

    @RequestMapping(value = "/farmacie.dtd", method = RequestMethod.GET)
    public HttpEntity<byte[]> getDTDFile() throws Exception {
        return getFile("farmacie.dtd");
    }

    @RequestMapping(value = "/farmacie.xsl", method = RequestMethod.GET)
    public HttpEntity<byte[]> getXSLFile() throws Exception {
        return getFile("farmacie.xsl");
    }

    @RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
    public String getForm() throws Exception {
        return "fileUploadView";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        String fileName = "src/main/resources/files/" + file.getOriginalFilename();
        try {
            File uploadedFile = new File(fileName);
            FileUtils.writeByteArrayToFile(uploadedFile, file.getBytes());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "uploadFile";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String getError() {
        return "error";
    }

    @RequestMapping(value = "/selectForView", method = RequestMethod.GET)
    public String getFiles(Model model) {
        listFilesForFolder(model);
        return "selectForView";
    }

    private HttpEntity<byte[]> getFile(String fileName) throws Exception {
        if (fileName.contains(".xml")) {
            try {
                Farmacie farmacie = this.parser.parse(fileName);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        String file = "";
        String path = "src/main/resources/files/" + fileName;
        StreamSource source = new StreamSource(path);

        try {
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.transform(source, result);
            file = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        byte[] documentBody = file.getBytes();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "xml"));
        header.setContentLength(documentBody.length);
        return new HttpEntity<byte[]>(documentBody, header);
    }

    private void listFilesForFolder(Model model) {
        File folder = new File("src/main/resources/files/");
        File[] files = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (int index = 0; index < files.length; index++) {
            if (files[index].getName().contains(".xml")) {
                fileNames.add(files[index].getName());
            }
        }
        if (fileNames.isEmpty()) {
            model.addAttribute("message", "There are no xml files.");
        } else {
            model.addAttribute("message", "The xml files are: ");
        }
        model.addAttribute("files", fileNames);
    }
}
