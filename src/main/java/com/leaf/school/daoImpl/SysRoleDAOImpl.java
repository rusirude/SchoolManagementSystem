/**
 *@Author : Rusiru De Silva
 */

package com.leaf.school.daoImpl;

import java.util.List;

import com.leaf.school.Utility.CommonUtility;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.entity.StatusEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.leaf.school.dao.BaseDAO;
import com.leaf.school.dao.SysRoleDAO;
import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.entity.SysRoleEntity;




@Repository("sysRoleDAO")
public class SysRoleDAOImpl extends BaseDAO implements SysRoleDAO{

	@Override
	public boolean insert(SysRoleDTO sysRoleDTO){
		boolean isInsert = false;
		try{
			Session session = getSession();
			StatusEntity statusEntity = (StatusEntity)    session.load(StatusEntity.class,sysRoleDTO.getStatusId());
			SysRoleEntity sysRoleEntity = new SysRoleEntity();
			sysRoleEntity.setName(sysRoleDTO.getName());
			sysRoleEntity.setDescription(sysRoleDTO.getDescription());
			sysRoleEntity.setStatusEntity(statusEntity);
			sysRoleEntity.setAddedBy(sysRoleDTO.getAddedBy());
			sysRoleEntity.setAddedOn(CommonUtility.getCurrentTimeStamp());
			session.save(sysRoleEntity);
			session.flush();

			isInsert = true;
		}
		catch (Exception e){
			isInsert = false;
		}
		return isInsert;
	}
	@Override
	@SuppressWarnings("unchecked")
	public boolean update(SysRoleDTO sysRoleDTO){
		boolean isUpdated = false;
		try{
			Session session = getSession();
			SysRoleEntity sysRoleEntity = (SysRoleEntity) session.get(SysRoleEntity.class, sysRoleDTO.getId());
			StatusEntity statusEntity = (StatusEntity)    session.load(StatusEntity.class,sysRoleDTO.getStatusId());
			session.evict(sysRoleEntity);
			sysRoleEntity.setName(sysRoleDTO.getName());
			sysRoleEntity.setDescription(sysRoleDTO.getDescription());
			sysRoleEntity.setStatusEntity(statusEntity);
			sysRoleEntity.setUpdatedBy(sysRoleDTO.getUpdatedBy());
			sysRoleEntity.setUpdatedOn(CommonUtility.getCurrentTimeStamp());
			session.update(sysRoleEntity);
			session.flush();
			isUpdated = true;
		}
		catch (Exception e){
			System.out.println(e);
			isUpdated = false;
		}
		return isUpdated;
	}
	@Override
	public boolean delete(SysRoleDTO sysRoleDTO){
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public SysRoleDTO find(SysRoleDTO sysRoleDTO){
		SysRoleDTO returnSysRoleDTO = null;
		try{
			Session session = getSession();
			Criteria criteria = session.createCriteria(SysRoleEntity.class).add(Restrictions.eq("id", sysRoleDTO.getId()));
			SysRoleEntity sysRoleEntity = (SysRoleEntity) criteria.uniqueResult();
			if(sysRoleEntity != null){
				returnSysRoleDTO = new SysRoleDTO();
				returnSysRoleDTO.setId(sysRoleEntity.getId());
				returnSysRoleDTO.setName(sysRoleEntity.getName());
				returnSysRoleDTO.setDescription(sysRoleEntity.getDescription());
				returnSysRoleDTO.setAddedBy(sysRoleEntity.getAddedBy());
				returnSysRoleDTO.setAddedOn(sysRoleEntity.getAddedOn());
				returnSysRoleDTO.setUpdatedBy(sysRoleEntity.getUpdatedBy());
				returnSysRoleDTO.setUpdatedOn(sysRoleEntity.getUpdatedOn());

			}

		}
		catch (Exception e){

		}
		 return  returnSysRoleDTO;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SysRoleDTO> getAllRoles(){
		List<SysRoleDTO> sysRoles = null;
		try {
			Session session = getSession();
			Criteria criteria = session.createCriteria(SysRoleEntity.class)
					.createAlias("status", "status");;
			Projection projection = Projections
					.projectionList()
					.add(Property.forName("id").as("id"))
					.add(Property.forName("name").as("name"))
					.add(Property.forName("description").as("description"))
					.add(Property.forName("status.id").as("statusId"))
					.add(Property.forName("status.code").as("statusCode"))
					.add(Property.forName("addedBy").as("addedBy"))
					.add(Property.forName("addedOn").as("addedOn"))
					.add(Property.forName("updatedBy").as("updatedBy"))
					.add(Property.forName("updatedOn").as("updatedOn"));

			criteria.setProjection(projection);
			sysRoles = criteria.setResultTransformer(Transformers.aliasToBean(SysRoleDTO.class)).list();
		}
		catch (Exception e){

		}

		return sysRoles;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<SysRoleDTO> getAllRoles(DataTableRequestDTO dataTableRequestDTO){
		List<SysRoleDTO> sysRoles = null;
		try {
			Session session = getSession();
			Criteria criteria = session.createCriteria(SysRoleEntity.class)
					.setFirstResult(dataTableRequestDTO.getStart() - 1)
					.setMaxResults(dataTableRequestDTO.getLength())
					.createAlias("status", "status");
			Projection projection = Projections
					.projectionList()
					.add(Property.forName("id").as("id"))
					.add(Property.forName("name").as("name"))
					.add(Property.forName("description").as("description"))
					.add(Property.forName("status.id").as("statusId"))
					.add(Property.forName("status.code").as("statusCode"))
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

			sysRoles = criteria.setResultTransformer(Transformers.aliasToBean(SysRoleDTO.class)).list();
		}
		catch (Exception e){
			System.out.println(e);
		}

		return sysRoles;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Integer getRowCount(DataTableRequestDTO dataTableRequestDTO){
		Integer rowCount = 0;
		try {
			Session session = getSession();
			Criteria criteria = session.createCriteria(SysRoleEntity.class)
					.setProjection(Projections.count("id"));
			Long value = (Long) criteria.uniqueResult();
			rowCount = Integer.valueOf(value.intValue());

		}
		catch (Exception e){
			rowCount = 0;
		}
		return rowCount;
	}

}
