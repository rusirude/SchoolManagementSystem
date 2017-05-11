package com.leaf.school.service;
/**
 *@Author : Rusiru De Silva
 */

import java.util.List;

import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.dto.common.DataTableResponseDTO;

public interface SysRoleService {
	AjaxResponseDTO saveSysRole(SysRoleDTO sysRoleDTO);
	AjaxResponseDTO updateSysRole(SysRoleDTO sysRoleDTO);
	DataTableResponseDTO getRolesForDataTable(DataTableRequestDTO dataTableRequestDTO);
}
