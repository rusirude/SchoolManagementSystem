/**
 * @Author : Rusiru De Silva
 */

package com.leaf.school.daoImpl;

import com.leaf.school.Utility.CommonUtility;
import com.leaf.school.dao.BaseDAO;
import com.leaf.school.dao.SysRoleDAO;
import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.entity.StatusEntity;
import com.leaf.school.entity.SysRoleEntity;
import com.leaf.school.enums.DefaultStatusCodeEnum;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("sysRoleDAO")
public class SysRoleDAOImpl extends BaseDAO implements SysRoleDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void insert(SysRoleDTO sysRoleDTO) {
        Session session = getSession();
        StatusEntity statusEntity = session.load(StatusEntity.class, sysRoleDTO.getStatus());
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        sysRoleEntity.setName(sysRoleDTO.getName());
        sysRoleEntity.setDescription(sysRoleDTO.getDescription());
        sysRoleEntity.setStatusEntity(statusEntity);
        sysRoleEntity.setAddedBy(sysRoleDTO.getAddedBy());
        sysRoleEntity.setAddedOn(CommonUtility.getCurrentTimeStamp());
        session.save(sysRoleEntity);
        session.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public void update(SysRoleDTO sysRoleDTO) {

        Session session = getSession();
        SysRoleEntity sysRoleEntity = session.load(SysRoleEntity.class, sysRoleDTO.getId());
        StatusEntity statusEntity = session.load(StatusEntity.class, sysRoleDTO.getStatus());
        session.evict(sysRoleEntity);
        sysRoleEntity.setName(sysRoleDTO.getName());
        sysRoleEntity.setDescription(sysRoleDTO.getDescription());
        sysRoleEntity.setStatusEntity(statusEntity);
        sysRoleEntity.setUpdatedBy(sysRoleDTO.getUpdatedBy());
        sysRoleEntity.setUpdatedOn(CommonUtility.getCurrentTimeStamp());
        session.update(sysRoleEntity);
        session.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(SysRoleDTO sysRoleDTO) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public SysRoleDTO find(long sysRoleId) {
        SysRoleDTO returnSysRoleDTO = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysRoleEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.and(
                                Restrictions.eq("id", sysRoleId),
                                Restrictions.not(
                                        Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.DELETE.getCode())
                                )
                        )
                );
        SysRoleEntity sysRoleEntity = (SysRoleEntity) criteria.uniqueResult();
        if (sysRoleEntity != null) {
            returnSysRoleDTO = new SysRoleDTO();
            returnSysRoleDTO.setId(sysRoleEntity.getId());
            returnSysRoleDTO.setName(sysRoleEntity.getName());
            returnSysRoleDTO.setDescription(sysRoleEntity.getDescription());
            populateCommonDTO(returnSysRoleDTO, sysRoleEntity);
        }
        return returnSysRoleDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<SysRoleDTO> getActiveStatusSysRole() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysRoleEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.ACTIVE.getCode())
                );
        Projection projection = Projections
                .projectionList()
                .add(Property.forName("id").as("id"))
                .add(Property.forName("name").as("name"))
                .add(Property.forName("description").as("description"))
                .add(Property.forName("statusEntity.id").as("status"))
                .add(Property.forName("statusEntity.description").as("statusDescription"))
                .add(Property.forName("addedBy").as("addedBy"))
                .add(Property.forName("addedOn").as("addedOn"))
                .add(Property.forName("updatedBy").as("updatedBy"))
                .add(Property.forName("updatedOn").as("updatedOn"));

        criteria.setProjection(projection);
        return criteria.setResultTransformer(Transformers.aliasToBean(SysRoleDTO.class)).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<SysRoleDTO> getSysRoleByStatus(String statusCode) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysRoleEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.eq("statusEntity.code", statusCode)
                );
        Projection projection = Projections
                .projectionList()
                .add(Property.forName("id").as("id"))
                .add(Property.forName("name").as("name"))
                .add(Property.forName("description").as("description"))
                .add(Property.forName("statusEntity.id").as("status"))
                .add(Property.forName("statusEntity.description").as("statusDescription"))
                .add(Property.forName("addedBy").as("addedBy"))
                .add(Property.forName("addedOn").as("addedOn"))
                .add(Property.forName("updatedBy").as("updatedBy"))
                .add(Property.forName("updatedOn").as("updatedOn"));

        criteria.setProjection(projection);
        return criteria.setResultTransformer(Transformers.aliasToBean(SysRoleDTO.class)).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<SysRoleDTO> getAllRolesForGrid(DataTableRequestDTO dataTableRequestDTO) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysRoleEntity.class)
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
                .add(Property.forName("id").as("id"))
                .add(Property.forName("name").as("name"))
                .add(Property.forName("description").as("description"))
                .add(Property.forName("statusEntity.id").as("status"))
                .add(Property.forName("statusEntity.description").as("statusDescription"))
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

        return criteria.setResultTransformer(Transformers.aliasToBean(SysRoleDTO.class)).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public long getRowCountForGrid(DataTableRequestDTO dataTableRequestDTO) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(SysRoleEntity.class)
                .createAlias("statusEntity", "statusEntity")
                .add(
                        Restrictions.not(
                                Restrictions.eq("statusEntity.code", DefaultStatusCodeEnum.DELETE.getCode())
                        )
                )
                .setProjection(Projections.count("id"));
        return (Long) criteria.uniqueResult();
    }

}
