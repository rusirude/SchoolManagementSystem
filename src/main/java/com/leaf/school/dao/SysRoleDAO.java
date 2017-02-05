/**
 *@Author : Rusiru De Silva
 */

package com.leaf.school.dao;

import java.util.List;

import com.leaf.school.dto.SysRoleDTO;

public interface SysRoleDAO {

	boolean insert(SysRoleDTO sysRoleDTO);
	boolean update(SysRoleDTO sysRoleDTO);
	boolean delete(SysRoleDTO sysRoleDTO);
	SysRoleDTO find(SysRoleDTO sysRoleDTO);
	List<SysRoleDTO> getAllRoles();

}
