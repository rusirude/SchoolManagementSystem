/**
 *@Author : Rusiru De Silva
 */

package com.leaf.school.dao;

import java.util.List;

import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;

public interface SysRoleDAO {

	boolean insert(SysRoleDTO sysRoleDTO);
	boolean update(SysRoleDTO sysRoleDTO);
	boolean delete(SysRoleDTO sysRoleDTO);
	SysRoleDTO find(SysRoleDTO sysRoleDTO);
	List<SysRoleDTO> getAllRoles();
	List<SysRoleDTO> getAllRoles(DataTableRequestDTO dataTableGeideDTO);
	Integer getRowCount(DataTableRequestDTO dataTableRequestDTO);

}
