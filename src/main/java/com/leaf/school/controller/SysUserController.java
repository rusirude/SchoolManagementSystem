package com.leaf.school.controller;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping(value = "/searchAllUsers", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDTO searchUser() {
        return sysUserService.getAllActiveUsers();
    }
}
