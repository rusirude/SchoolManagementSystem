/**
 * @Author : Rusiru De Silva
 */
package com.leaf.school.daoImpl;

import com.leaf.school.Utility.CommonUtility;
import com.leaf.school.dao.BaseDAO;
import com.leaf.school.dao.SysUserDAO;
import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.entity.StatusEntity;
import com.leaf.school.entity.SysUserEntity;
import com.leaf.school.enums.DefaultStatusCodeEnum;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("SysUserDAO")
public class SysUserDAOImpl extends BaseDAO implements SysUserDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void insert(SysUserDTO sysUserDTO) {
        Session session = getSession();
        StatusEntity statusEntity = session.load(StatusEntity.class, sysUserDTO.getStatus());
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername(sysUserDTO.getUsername());
        sysUserEntity.setPassword(sysUserDTO.getPassword());
        sysUserEntity.setName(sysUserDTO.getName());
        sysUserEntity.setStatusEntity(statusEntity);
        sysUserEntity.setFirstLogin(sysUserDTO.getFirstLogin());
        sysUserEntity.setPasswordResetRequested(sysUserDTO.getPasswordResetRequested());
        sysUserEntity.setAddedBy(sysUserDTO.getAddedBy());
        sysUserEntity.setAddedOn(CommonUtility.getCurrentTimeStamp());
        session.save(statusEntity);
        session.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(SysUserDTO sysUserDTO) {
        Session session = getSession();
        SysUserEntity sysUserEntity = session.load(SysUserEntity.class, sysUserDTO.getUsername());
        StatusEntity statusEntity = session.load(StatusEntity.class, sysUserDTO.getStatus());
        session.evict(sysUserEntity);
        sysUserEntity.setUsername(sysUserDTO.getUsername());
        sysUserEntity.setPassword(sysUserDTO.getPassword());
        sysUserEntity.setName(sysUserDTO.getName());
        sysUserEntity.setStatusEntity(statusEntity);
        sysUserEntity.setFirstLogin(sysUserDTO.getFirstLogin());
        sysUserEntity.setPasswordResetRequested(sysUserDTO.getPasswordResetRequested());
        sysUserEntity.setUpdatedBy(sysUserDTO.getUpdatedBy());
        sysUserEntity.setUpdatedOn(CommonUtility.getCurrentTimeStamp());
        session.update(statusEntity);
        session.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(SysUserDTO sysUserDTO) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SysUserDTO find(String username) {
        SysUserDTO returnSysUserDTO = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.and(
                                Restrictions.eq("username", username),
                                Restrictions.not(
                                        Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.DELETE.getCode())
                                )
                        )
                );
        SysUserEntity sysUserEntity = (SysUserEntity) criteria.uniqueResult();
        if (sysUserEntity != null) {
            returnSysUserDTO.setUsername(sysUserEntity.getUsername());
            returnSysUserDTO.setName(sysUserEntity.getName());
            returnSysUserDTO.setStatus(sysUserEntity.getStatusEntity().getId());
            returnSysUserDTO.setStatusDescription(sysUserEntity.getStatusEntity().getDescription());
            returnSysUserDTO.setFirstLogin(sysUserEntity.getFirstLogin());
            returnSysUserDTO.setPasswordResetRequested(sysUserEntity.getPasswordResetRequested());
            populateCommonDTO(returnSysUserDTO, sysUserEntity);
        }

        return returnSysUserDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<SysUserDTO> getActiveStatusSysUser() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.ACTIVE.getCode())
                );
        Projection projection = Projections
                .projectionList()
                .add(Property.forName("username").as("username"))
                .add(Property.forName("name").as("name"))
                .add(Property.forName("description").as("description"))
                .add(Property.forName("statusEntity.id").as("status"))
                .add(Property.forName("statusEntity.description").as("statusDescription"))
                .add(Property.forName("firstLogin").as("firstLogin"))
                .add(Property.forName("passwordResetRequested").as("passwordResetRequested"))
                .add(Property.forName("addedBy").as("addedBy"))
                .add(Property.forName("addedOn").as("addedOn"))
                .add(Property.forName("updatedBy").as("updatedBy"))
                .add(Property.forName("updatedOn").as("updatedOn"));

        criteria.setProjection(projection);
        return criteria.setResultTransformer(Transformers.aliasToBean(SysUserDTO.class)).list();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<SysUserDTO> getSysUserByUsername(String username) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.and(
                                Restrictions.eq("username", username),
                                Restrictions.not(
                                        Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.DELETE.getCode())
                                )
                        )
                );
        Projection projection = Projections
                .projectionList()
                .add(Property.forName("username").as("username"))
                .add(Property.forName("name").as("name"))
                .add(Property.forName("password").as("password"))
                .add(Property.forName("statusEntity.id").as("status"))
                .add(Property.forName("statusEntity.code").as("statusCode"))
                .add(Property.forName("statusEntity.description").as("statusDescription"))
                .add(Property.forName("firstLogin").as("firstLogin"))
                .add(Property.forName("passwordResetRequested").as("passwordResetRequested"))
                .add(Property.forName("addedBy").as("addedBy"))
                .add(Property.forName("addedOn").as("addedOn"))
                .add(Property.forName("updatedBy").as("updatedBy"))
                .add(Property.forName("updatedOn").as("updatedOn"));

        criteria.setProjection(projection);
        return criteria.setResultTransformer(Transformers.aliasToBean(SysUserDTO.class)).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<SysUserDTO> getAllUsersForGrid(DataTableRequestDTO dataTableRequestDTO) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserEntity.class)
                .setFirstResult(dataTableRequestDTO.getStart() - 1)
                .setMaxResults(dataTableRequestDTO.getLength())
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.not(
                                Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.DELETE.getCode())
                        )
                );
        Projection projection = Projections
                .projectionList()
                .add(Property.forName("username").as("username"))
                .add(Property.forName("name").as("name"))
                .add(Property.forName("description").as("description"))
                .add(Property.forName("statusEntity.id").as("status"))
                .add(Property.forName("statusEntity.description").as("statusDescription"))
                .add(Property.forName("firstLogin").as("firstLogin"))
                .add(Property.forName("passwordResetRequested").as("passwordResetRequested"))
                .add(Property.forName("addedBy").as("addedBy"))
                .add(Property.forName("addedOn").as("addedOn"))
                .add(Property.forName("updatedBy").as("updatedBy"))
                .add(Property.forName("updatedOn").as("updatedOn"));
        criteria.setProjection(projection);
        Order order = null;
        if (dataTableRequestDTO.getSortOrder().equals("asc")) {
            order = Order.asc(dataTableRequestDTO.getSortColumnName());
        } else if (dataTableRequestDTO.getSortOrder().equals("desc")) {
            order = Order.desc(dataTableRequestDTO.getSortColumnName());
        }
        criteria.addOrder(order);
        return criteria.setResultTransformer(Transformers.aliasToBean(SysUserDTO.class)).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public long getRowCountForGrid(DataTableRequestDTO dataTableRequestDTO) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.not(
                                Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.DELETE.getCode())
                        )
                )
                .setProjection(Projections.count("username"));
        return (Long) criteria.uniqueResult();
    }
}
