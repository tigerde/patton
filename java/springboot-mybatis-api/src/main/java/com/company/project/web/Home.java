package com.company.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by patton on 2017/9/28.
 */
@Controller
public class Home {
    @GetMapping("/")
    public String home(){
        return "redirect:swagger-ui.html";
    }
}
