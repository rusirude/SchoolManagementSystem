package com.leaf.school.service;

import java.util.List;

import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.SysUserDTO;

public interface SysUserService {
	
	public List<SysUserDTO> getAllUsers();
	public AjaxResponseDTO checkUserAvailability(String username);
	public AjaxResponseDTO getSecurityQuestionsForUser(String username);

}
