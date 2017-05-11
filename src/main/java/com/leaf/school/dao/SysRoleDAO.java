package com.leaf.school.dao;
/**
 * @Author : Rusiru De Silva
 */

import com.leaf.school.dto.SysRoleDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;

import java.util.List;

public interface SysRoleDAO {

    /**
     * Insert SysRole
     *
     * @param sysRoleDTO - System Role Details by SysRoleDTO
     */
    void insert(SysRoleDTO sysRoleDTO);

    /**
     * Update SysRole
     *
     * @param sysRoleDTO - System Role Details by SysRoleDTO
     */
    void update(SysRoleDTO sysRoleDTO);

    /**
     * Delete SysRole - Not Implemented
     *
     * @param sysRoleDTO - System Role Details by SysRoleDTO
     */
    void delete(SysRoleDTO sysRoleDTO);

    /**
     * find SysRole By Id
     *
     * @param sysRoleId - System Role Id
     * @return SysRoleDTO
     */
    SysRoleDTO find(long sysRoleId);

    /**
     * find All SysRole where Status is Active
     *
     * @return List of SysRoleDTO
     */
    List<SysRoleDTO> getActiveStatusSysRole();

    /**
     * find All SysRole By Status
     *
     * @param statusCode - Status Code
     * @return List of SysRoleDTO
     */
    List<SysRoleDTO> getSysRoleByStatus(String statusCode);

    /**
     * find  not deleted  SysRole For Data Grid
     *
     * @param dataTableRequestDTO - Data Table Request DTO
     * @return List of SysRoleDTO
     */
    List<SysRoleDTO> getAllRolesForGrid(DataTableRequestDTO dataTableRequestDTO);

    /**
     * find not deleted  SysRole Count For Data Grid
     *
     * @param dataTableRequestDTO - Data Table Request DTO
     * @return long - Count of SysRole
     */
    long getRowCountForGrid(DataTableRequestDTO dataTableRequestDTO);

}
