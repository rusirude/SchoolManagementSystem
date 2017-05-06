package com.leaf.school.dao;

import java.util.List;

import com.leaf.school.dto.SecurityQuestionDTO;
import com.leaf.school.dto.SysUserDTO;

public interface SysUserDAO {
	
	public List<SysUserDTO> getUsers();
	public List<SysUserDTO> getUsersByStatus(String statusCode) throws Exception;
	public SysUserDTO getUserByUsername(SysUserDTO sysUserDTO) throws Exception;
	public List<SecurityQuestionDTO> getSecurityQuactionByUsername(SysUserDTO user)throws Exception;
	
}
