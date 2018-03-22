package constantin.rosana.app;

import constantin.rosana.generated.Farmacie;
import constantin.rosana.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/parse", method = RequestMethod.GET)
    public String getParsedFile(@RequestParam(name = "filename") String fileName, Model model) throws Exception {
        Farmacie farmacie = this.parser.parse(fileName);
        model.addAttribute("listaRetete", farmacie.getReteta());
        return "parsed";
    }
}
