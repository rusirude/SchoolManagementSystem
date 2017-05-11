package com.leaf.school.service;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.common.LoginDTO;

public interface AuthorizationService {

    AjaxResponseDTO login(LoginDTO loginDTO);

    AjaxResponseDTO logout();
}
