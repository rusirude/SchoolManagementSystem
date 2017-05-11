package com.leaf.school.dao;

import com.leaf.school.dto.SysUserDTO;
import com.leaf.school.dto.common.DataTableRequestDTO;

import java.util.List;

public interface SysUserDAO {

    /**
     * Insert SysUser
     *
     * @param sysUserDTO - System User Details by SysUserDTO
     */
    void insert(SysUserDTO sysUserDTO);

    /**
     * Update SysUser
     *
     * @param sysUserDTO - System User Details by SysUserDTO
     */
    void update(SysUserDTO sysUserDTO);

    /**
     * Delete SysUser - Not Implemented
     *
     * @param sysUserDTO - System User Details by SysRoleDTO
     */
    void delete(SysUserDTO sysUserDTO);

    /**
     * find SysUser By Username
     *
     * @param username - System User username
     * @return SysUserDTO
     */
    SysUserDTO find(String username);

    /**
     * find All SysRole where Status is Active
     *
     * @return List of SysRoleDTO
     */
    List<SysUserDTO> getActiveStatusSysUser();

    /**
     * find All SysUser By username and password
     *
     * @param username - SysUser Username
     * @return List of SysUserDTO
     */
    List<SysUserDTO> getSysUserByUsername(String username);

    /**
     * find  not deleted  SysUser For Data Grid
     *
     * @param dataTableRequestDTO - Data Table Request DTO
     * @return List of SysUserDTO
     */
    List<SysUserDTO> getAllUsersForGrid(DataTableRequestDTO dataTableRequestDTO);

    /**
     * find not deleted  SysUser Count For Data Grid
     *
     * @param dataTableRequestDTO - Data Table Request DTO
     * @return long - Count of SysUser
     */
    long getRowCountForGrid(DataTableRequestDTO dataTableRequestDTO);
}
