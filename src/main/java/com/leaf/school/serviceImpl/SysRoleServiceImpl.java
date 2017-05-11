package com.leaf.school.serviceImpl;

import com.leaf.school.Utility.CommonUtility;
import com.leaf.school.dao.SysRoleDAO;
import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;
import com.leaf.school.dto.common.DataTableResponseDTO;
import com.leaf.school.enums.ResponseCodeEnum;
import com.leaf.school.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDAO sysRoleDAO;


    @Override
    @Transactional
    public AjaxResponseDTO saveSysRole(SysRoleDTO sysRoleDTO) {
        AjaxResponseDTO ajaxResponseDTO = new AjaxResponseDTO("", "");
        try {
            sysRoleDTO.setAddedBy("SYSTEM");//To Do Rusiru De Silva
            sysRoleDTO.setAddedOn(CommonUtility.getCurrentTimeStamp());
            sysRoleDAO.insert(sysRoleDTO);
            ajaxResponseDTO.setCode(ResponseCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            ajaxResponseDTO.setCode(ResponseCodeEnum.ERROR.getCode());
        }
        return ajaxResponseDTO;
    }

    @Override
    @Transactional
    public AjaxResponseDTO updateSysRole(SysRoleDTO sysRoleDTO) {
        AjaxResponseDTO ajaxResponseDTO = new AjaxResponseDTO("", "");
        try {
            sysRoleDTO.setUpdatedBy("SYSTEM");//To Do Rusiru De Silva
            sysRoleDTO.setUpdatedOn(CommonUtility.getCurrentTimeStamp());
            sysRoleDAO.update(sysRoleDTO);
            ajaxResponseDTO.setCode(ResponseCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            ajaxResponseDTO.setCode(ResponseCodeEnum.ERROR.getCode());
        }
        return ajaxResponseDTO;
    }

    @Override
    @Transactional
    public DataTableResponseDTO getRolesForDataTable(DataTableRequestDTO dataTableRequestDTO) {
        DataTableResponseDTO dataTableResponseDTO = new DataTableResponseDTO();
        try {
            Long rowCount = sysRoleDAO.getRowCountForGrid(dataTableRequestDTO);
            List<SysRoleDTO> sysRoleDTOs = sysRoleDAO.getAllRolesForGrid(dataTableRequestDTO);
            dataTableResponseDTO.setData(sysRoleDTOs);
            dataTableResponseDTO.setDraw(dataTableRequestDTO.getDraw());
            dataTableResponseDTO.setRecordsTotal(rowCount);
            dataTableResponseDTO.setRecordsFiltered(rowCount);
        } catch (Exception e) {
            dataTableResponseDTO.setData(null);
            dataTableResponseDTO.setDraw(dataTableRequestDTO.getDraw());
            dataTableResponseDTO.setRecordsTotal((long) 0);
            dataTableResponseDTO.setRecordsFiltered((long) 0);
        }

        return dataTableResponseDTO;

    }


}
