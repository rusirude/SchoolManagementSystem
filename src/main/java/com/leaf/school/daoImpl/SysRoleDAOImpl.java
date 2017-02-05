/**
 *@Author : Rusiru De Silva
 */

package com.leaf.school.daoImpl;

import java.util.List;

import com.leaf.school.Utility.CommonUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.leaf.school.dao.BaseDAO;
import com.leaf.school.dao.SysRoleDAO;
import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.entity.SysRoleEntity;
import org.springframework.transaction.annotation.Transactional;


@Repository("sysRoleDAO")
public class SysRoleDAOImpl extends BaseDAO implements SysRoleDAO{

	@Override
	public boolean insert(SysRoleDTO sysRoleDTO){
		boolean isInsert = false;
		try{
			Session session = getSession();
			SysRoleEntity sysRoleEntity = new SysRoleEntity();
			sysRoleEntity.setName(sysRoleDTO.getName());
			sysRoleEntity.setDescription(sysRoleDTO.getDescription());
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
	public boolean update(SysRoleDTO sysRoleDTO){
		boolean isUpdated = false;
		try{
			Session session = getSession();
			SysRoleEntity sysRoleEntity = (SysRoleEntity) session.get(SysRoleEntity.class,sysRoleDTO.getId());
			session.evict(sysRoleEntity);
			sysRoleEntity.setName(sysRoleDTO.getName());
			sysRoleEntity.setDescription(sysRoleDTO.getDescription());
			sysRoleEntity.setUpdatedBy(sysRoleDTO.getUpdatedBy());
			sysRoleEntity.setUpdatedOn(CommonUtility.getCurrentTimeStamp());
			session.flush();
			isUpdated = true;
		}
		catch (Exception e){
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
			Criteria criteria = session.createCriteria(SysRoleEntity.class);
			Projection projection = Projections
					.projectionList()
					.add(Property.forName("id").as("id"))
					.add(Property.forName("name").as("name"))
					.add(Property.forName("description").as("description"))
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

}
