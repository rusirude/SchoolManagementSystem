package com.leaf.school.serviceImpl;

import java.util.List;

import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.dto.common.DataTableResponseDTO;
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
