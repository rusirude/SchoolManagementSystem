package com.leaf.school.serviceImpl;

import com.leaf.school.dao.SysUserDAO;
import com.leaf.school.dto.SecurityQuestionDTO;
import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.enums.DefaultStatusCodeEnum;
import com.leaf.school.enums.ResponseCodeEnum;
import com.leaf.school.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysUsereService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserDAO sysUserDAO;

    @Override
    @Transactional
    public AjaxResponseDTO getAllActiveUsers() {
        String code = ResponseCodeEnum.ERROR.getCode();
        List<SysUserDTO> sysUserDTOS = null;
        try {
            sysUserDTOS = sysUserDAO.getUsersByStatus(DefaultStatusCodeEnum.ACTIVE.getCode());
            code = ResponseCodeEnum.SUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new AjaxResponseDTO(code, sysUserDTOS);
    }

    @Override
    @Transactional
    public AjaxResponseDTO checkUserAvailability(String username) {
        AjaxResponseDTO response = null;
        SysUserDTO user = new SysUserDTO();
        SysUserDTO users = null;
        user.setUsername(username);
        try {
            /*-1 for server Error,
			 * 0 for not found,
			 * 1 For only one user found
			 * 2,3... multiple user fond (2,3,..number of users)*/
            users = sysUserDAO.getUserByUsername(user);

            response = new AjaxResponseDTO("", "");
            response.setMessage("Success");
            //response.setObj(new Integer(users.size()));
            response.setCode("");
        } catch (Exception e) {
            response = new AjaxResponseDTO("", "");
            response.setMessage("Server Error");
            response.setObj(new Integer(-1));
            response.setCode("");
            e.printStackTrace();
        }

        return response;
    }

    @Override
    @Transactional
    public AjaxResponseDTO getSecurityQuestionsForUser(String username) {
        AjaxResponseDTO response = null;
        SysUserDTO user = new SysUserDTO();
        List<SecurityQuestionDTO> questions = null;
        user.setUsername(username);
        try {
            questions = sysUserDAO.getSecurityQuactionByUsername(user);
            response = new AjaxResponseDTO("", "");
            response.setMessage("Success");
            response.setObj(questions);
            response.setCode("");
        } catch (Exception e) {
            response = new AjaxResponseDTO("", "");
            response.setMessage("Server Error");
            response.setCode("");
            e.printStackTrace();
        }
        return response;
    }

}
