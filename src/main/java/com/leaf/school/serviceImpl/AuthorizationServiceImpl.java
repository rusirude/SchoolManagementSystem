package com.leaf.school.serviceImpl;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.Utility.CommonConstant;
import com.leaf.school.dao.SysUserDAO;
import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.session.Session;
import com.leaf.school.enums.ResponseCodeEnum;
import com.leaf.school.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AuthorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    Session session;
    @Autowired
    SysUserDAO sysUserDAO;

    @Override
    @Transactional
    public AjaxResponseDTO login(SysUserDTO sysUserDTO) {
        String code = ResponseCodeEnum.ERROR.getCode();
        String message = "";
        try {
            SysUserDTO userDTO = sysUserDAO.getUserByUsername(sysUserDTO);
            switch (userDTO.getStatusCode()) {
                case CommonConstant.ACTIVE:
                    break;
                case CommonConstant.DEACT:
                    break;
            }
            session.setUsername(userDTO.getUsername());
            code = ResponseCodeEnum.SUCCESS.getCode();
        } catch (Exception e) {

        }
        return new AjaxResponseDTO(code, "login Success");
    }

    @Override
    @Transactional
    public AjaxResponseDTO logout() {
        session.setUsername(null);
        return new AjaxResponseDTO("SUCCESS", "logout Success");
    }
}
