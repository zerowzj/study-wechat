package com.company.project.wechatweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test")
    public ModelAndView demo(HttpServletRequest request) {
        return new ModelAndView("test");
    }
}
