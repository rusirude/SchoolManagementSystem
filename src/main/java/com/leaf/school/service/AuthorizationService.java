package com.leaf.school.service;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;

public interface AuthorizationService {

    AjaxResponseDTO login(SysUserDTO sysUserDTO);

    AjaxResponseDTO logout();
}
