package com.company.project.wechatweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTML;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test")
    public ModelAndView demo(HttpServletRequest request) {
        System.out.println("ssss");
        return new ModelAndView("test");
    }
}
