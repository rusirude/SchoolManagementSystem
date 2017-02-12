package com.leaf.school.controller;

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
    public String viewUserRole(){
        return  "userRole";
    }

    @RequestMapping(value="/loadUserRoleForGrid",method = RequestMethod.POST)
    @ResponseBody
    public DataTableResponseDTO loadUserRole(@RequestBody DataTableRequestDTO dataTableRequestDTO){
       return sysRoleService.getRolesForDataTable(dataTableRequestDTO);
    }
}
