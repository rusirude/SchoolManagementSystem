package com.leaf.school.serviceImpl;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.Utility.Encryptor;
import com.leaf.school.dao.SysUserDAO;
import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.common.LoginDTO;
import com.leaf.school.dto.session.Session;
import com.leaf.school.enums.DefaultStatusCodeEnum;
import com.leaf.school.enums.LoginResponseCodeEnum;
import com.leaf.school.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public AjaxResponseDTO login(LoginDTO loginDTO) {
        String code = LoginResponseCodeEnum.ERROR.getCode();
        try {
            List<SysUserDTO> sysUserDTOs = sysUserDAO.getSysUserByUsername(loginDTO.getUsername().trim());
            if (sysUserDTOs == null || sysUserDTOs.size() == 0) {
                code = LoginResponseCodeEnum.LOGIN_FAILED.getCode();
            } else if (sysUserDTOs.size() == 1 && "Y".equals(sysUserDTOs.get(0).getPasswordResetRequested())) {
                code = LoginResponseCodeEnum.PASSWORD_RESET_REQUESTED.getCode();
            } else if (sysUserDTOs.size() == 1 && DefaultStatusCodeEnum.DEACT.getCode().equals(sysUserDTOs.get(0).getStatusCode())) {
                code = LoginResponseCodeEnum.ACCOUNT_LOCK.getCode();
            } else if (sysUserDTOs.size() == 1 && DefaultStatusCodeEnum.ACTIVE.getCode().equals(sysUserDTOs.get(0).getStatusCode())) {
                if (Encryptor.getHashCode(loginDTO.getPassword().trim()).equals(sysUserDTOs.get(0).getPassword().trim())) {
                    switch (sysUserDTOs.get(0).getFirstLogin()) {
                        case "Y":
                            code = LoginResponseCodeEnum.FIRST_LOGIN.getCode();
                            break;
                        default:
                            code = LoginResponseCodeEnum.LOGIN_SUCCESS.getCode();
                    }
                    session.setUsername(sysUserDTOs.get(0).getUsername().trim());
                } else {
                    code = LoginResponseCodeEnum.LOGIN_FAILED.getCode();
                }
            } else {
                //todo Rusiru add log here
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new AjaxResponseDTO(code);
    }

    @Override
    @Transactional
    public AjaxResponseDTO logout() {
        session.setUsername(null);
        return new AjaxResponseDTO("SUCCESS", "logout Success");
    }

}
