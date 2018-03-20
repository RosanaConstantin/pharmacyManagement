package constantin.rosana.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rosana-Constantin on 18-Mar-18.
 */

@Controller
public class AppController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }
}
