package com.company.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by patton on 2017/9/28.
 */
@Controller
public class Home {
    @GetMapping("/")
    public String home(){
        return "index";
//        return "redirect:swagger-ui.html";
    }
}
