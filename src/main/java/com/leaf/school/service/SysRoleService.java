package com.leaf.school.service;

import java.util.List;

import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.dto.common.DataTableResponseDTO;

public interface SysRoleService {
	List<SysRoleDTO> getAllRoles();
	DataTableResponseDTO getRolesForDataTable(DataTableRequestDTO dataTableRequestDTO);
}
