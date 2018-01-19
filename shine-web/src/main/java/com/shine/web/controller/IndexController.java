package com.shine.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class IndexController {

    @RequestMapping(value = {"/index"," ","/","index"})
    public ModelAndView index(){
        return new ModelAndView("index/");
    }
}
