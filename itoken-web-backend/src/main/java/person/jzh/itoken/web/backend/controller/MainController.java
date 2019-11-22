package person.jzh.itoken.web.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jzh
 * @version 1.0.0
 * @title MainController
 * @date 2019/11/5 11:27
 * @description
 */
@Controller
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }
}
