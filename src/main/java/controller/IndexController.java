package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by azat on 11.03.16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String getIndexPage(){
        return "index";
    }

}
