/**
 * @Author : Rusiru De Silva
 */
package com.leaf.school.daoImpl;

import com.leaf.school.dao.BaseDAO;
import com.leaf.school.dao.SysUserDAO;
import com.leaf.school.dto.SecurityQuestionDTO;
import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.entity.SysUserEntity;
import com.leaf.school.entity.SysUserQuestionMapEntity;
import com.leaf.school.enums.DefaultStatusCodeEnum;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("SysUserDAO")
public class SysUserDAOImpl extends BaseDAO implements SysUserDAO {

    @Override
    public List<SysUserDTO> getUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<SysUserDTO> getUsersByStatus(String statusCode) throws Exception {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(Restrictions.eq("statusEntity.code", statusCode));
        Projection projection = Projections
                .projectionList()
                .add(Property.forName("username").as("username"))
                .add(Property.forName("name").as("name"))
                .add(Property.forName("statusEntity.description").as("statusDescription"));
        criteria.setProjection(projection);
        return criteria.setResultTransformer(Transformers.aliasToBean(SysUserDTO.class)).list();

    }


    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public SysUserDTO getUserByUsername(SysUserDTO sysUserDTO) throws Exception {
        SysUserDTO userDTO = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(Restrictions.and(
                        Restrictions.eq("username", sysUserDTO.getUsername()),
                        Restrictions.not(
                                Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.DELETE.getCode()))
                        )
                );
        SysUserEntity sysUserEntity = (SysUserEntity) criteria.uniqueResult();
        if (sysUserEntity != null) {
            userDTO = new SysUserDTO();
            userDTO.setUsername(sysUserEntity.getUsername());
            userDTO.setPassword(sysUserEntity.getPassword());
            userDTO.setName(sysUserEntity.getName());
            userDTO.setStatusCode(sysUserEntity.getStatusEntity().getCode());
            userDTO.setFirstLogin(sysUserEntity.getFirstLogin());
        }
        return userDTO;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SecurityQuestionDTO> getSecurityQuactionByUsername(SysUserDTO user) throws Exception {
        List<SecurityQuestionDTO> questions = null;
        String username = user.getUsername();
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserQuestionMapEntity.class)
                .add(Restrictions.eq("id.username", username))
                .createAlias("questionEntity", "questionEntity");
        Projection projection = Projections
                .projectionList()
                .add(Property.forName("id.questionId").as("id"))
                .add(Property.forName("questionEntity.question").as("question"));
        criteria.setProjection(projection);
        questions = criteria.setResultTransformer(Transformers.aliasToBean(SecurityQuestionDTO.class)).list();
        return questions;
    }
}
