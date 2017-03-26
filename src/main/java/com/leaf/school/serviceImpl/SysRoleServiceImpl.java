package com.leaf.school.serviceImpl;

import java.util.List;

import com.leaf.school.Utility.CommonUtility;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.dto.common.DataTableResponseDTO;
import com.leaf.school.enums.ResponseCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leaf.school.dao.SysRoleDAO;
import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.service.SysRoleService;


@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleDAO sysRoleDAO;


	@Override
	@Transactional
	public AjaxResponseDTO saveSysRole(SysRoleDTO sysRoleDTO){
		AjaxResponseDTO ajaxResponseDTO = new AjaxResponseDTO("","");
		try{
			sysRoleDTO.setAddedBy("SYSTEM");//To Do Rusiru De Silva
			sysRoleDTO.setAddedOn(CommonUtility.getCurrentTimeStamp());
			boolean isInserted = sysRoleDAO.insert(sysRoleDTO);
			if(isInserted == true){
				ajaxResponseDTO.setCode(ResponseCodeEnum.SUCCESS.name());
			}
			else{
				ajaxResponseDTO.setCode(ResponseCodeEnum.ERROR.name());
			}
		}
		catch(Exception e){
			ajaxResponseDTO.setCode(ResponseCodeEnum.ERROR.name());
		}
		return ajaxResponseDTO;
	}

	@Override
	@Transactional
	public AjaxResponseDTO updateSysRole(SysRoleDTO sysRoleDTO){
		AjaxResponseDTO ajaxResponseDTO = new AjaxResponseDTO("","");
		try{
			sysRoleDTO.setUpdatedBy("SYSTEM");//To Do Rusiru De Silva
			sysRoleDTO.setUpdatedOn(CommonUtility.getCurrentTimeStamp());
			boolean isUpdated = sysRoleDAO.update(sysRoleDTO);
			if(isUpdated == true){
				ajaxResponseDTO.setCode(ResponseCodeEnum.SUCCESS.name());
			}
			else{
				ajaxResponseDTO.setCode(ResponseCodeEnum.ERROR.name());
			}
		}
		catch(Exception e){
			ajaxResponseDTO.setCode(ResponseCodeEnum.ERROR.name());
		}
		return ajaxResponseDTO;
	}

	@Override
	@Transactional
	public List<SysRoleDTO> getAllRoles(){
		return sysRoleDAO.getAllRoles();
	}
	@Override
	@Transactional
	public DataTableResponseDTO getRolesForDataTable(DataTableRequestDTO dataTableRequestDTO){
		DataTableResponseDTO dataTableResponseDTO = new DataTableResponseDTO();
		try{
			Integer rowCount = sysRoleDAO.getRowCount(dataTableRequestDTO);
			List<SysRoleDTO> sysRoleDTOs = sysRoleDAO.getAllRoles(dataTableRequestDTO);
			dataTableResponseDTO.setData(sysRoleDTOs);
			dataTableResponseDTO.setDraw(dataTableRequestDTO.getDraw());
			dataTableResponseDTO.setRecordsTotal(rowCount);
			dataTableResponseDTO.setRecordsFiltered(rowCount);
		}
		catch (Exception e){
			dataTableResponseDTO.setData(null);
			dataTableResponseDTO.setDraw(dataTableRequestDTO.getDraw());
			dataTableResponseDTO.setRecordsTotal(0);
			dataTableResponseDTO.setRecordsFiltered(0);
		}

		return dataTableResponseDTO;

	}


}
