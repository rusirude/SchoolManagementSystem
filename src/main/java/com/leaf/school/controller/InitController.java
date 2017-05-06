/**
 * @Author : Rusiru De Silva
 */

package com.leaf.school.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InitController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getInit() {
        return "welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String viewWelcome(ModelMap model) {
        return "welcome";
    }

}