package com.leaf.school.controller;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.common.LoginDTO;
import com.leaf.school.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthorizationController {
    @Autowired
    AuthorizationService authorizationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDTO login(@RequestBody LoginDTO loginDTO) {
        return authorizationService.login(loginDTO);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDTO logout() {
        return authorizationService.logout();
    }
}
