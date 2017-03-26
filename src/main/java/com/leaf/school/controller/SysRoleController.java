package com.leaf.school.controller;

import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.dto.common.DataTableResponseDTO;
import com.leaf.school.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@Author : Rusiru De Silva
 */


@Controller
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @RequestMapping(value="/userRole",method = RequestMethod.GET)
    public String viewSysRole(){
        return  "userRole";
    }

    @RequestMapping(value="/loadUserRoleForGrid",method = RequestMethod.POST)
    @ResponseBody
    public DataTableResponseDTO loadSysRole(@RequestBody DataTableRequestDTO dataTableRequestDTO){
       return sysRoleService.getRolesForDataTable(dataTableRequestDTO);
    }

    @RequestMapping(value = "/saveSysRole",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDTO saveSysRole(@RequestBody SysRoleDTO sysRoleDTO){
        return sysRoleService.saveSysRole(sysRoleDTO);
    }
    @RequestMapping(value = "/updateSysRole",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDTO updateSysRole(@RequestBody SysRoleDTO sysRoleDTO){
        return sysRoleService.updateSysRole(sysRoleDTO);
    }
}
