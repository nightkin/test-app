package lv.k2611a.testapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class FrontPageController {


    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "hello";
    }


}
