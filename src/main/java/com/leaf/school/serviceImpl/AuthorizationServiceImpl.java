package com.leaf.school.serviceImpl;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.Utility.CommonConstant;
import com.leaf.school.Utility.Encryptor;
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
    @Autowired
    Encryptor encryptor;

    @Override
    @Transactional
    public AjaxResponseDTO login(SysUserDTO sysUserDTO) {
        String code = ResponseCodeEnum.ERROR.getCode();
        String message = "";
        Object obj = null;
        try {
            SysUserDTO userDTO = sysUserDAO.getUserByUsername(sysUserDTO);
            switch (userDTO.getStatusCode()) {
                case CommonConstant.ACTIVE:
                    if (userDTO.getPassword().equals(encryptor.getHashCode(sysUserDTO.getPassword())) & "Y".equals(userDTO.getFirstLogin())) {
                        session.setUsername(userDTO.getUsername());
                        code = ResponseCodeEnum.SUCCESS.getCode();
                        message = CommonConstant.LOGIN_SUCCESS;
                    } else if (userDTO.getPassword().equals(encryptor.getHashCode(sysUserDTO.getPassword()))) {
                        session.setUsername(userDTO.getUsername());
                        code = ResponseCodeEnum.SUCCESS.getCode();
                        message = CommonConstant.LOGIN_SUCCESS;
                    } else {
                        message = CommonConstant.LOGIN_FAILD;
                    }
                    break;
                case CommonConstant.DEACT:
                    message = CommonConstant.LOGIN_SUCCESS_LOCK;
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new AjaxResponseDTO(code, message);
    }

    @Override
    @Transactional
    public AjaxResponseDTO logout() {
        session.setUsername(null);
        return new AjaxResponseDTO("SUCCESS", "logout Success");
    }

}
