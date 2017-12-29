package com.study.upms.rpc.api;

import java.util.List;

import com.study.upms.dao.model.UpmsLog;
import com.study.upms.dao.model.UpmsOrganization;
import com.study.upms.dao.model.UpmsOrganizationExample;
import com.study.upms.dao.model.UpmsPermission;
import com.study.upms.dao.model.UpmsRole;
import com.study.upms.dao.model.UpmsRolePermission;
import com.study.upms.dao.model.UpmsSystem;
import com.study.upms.dao.model.UpmsSystemExample;
import com.study.upms.dao.model.UpmsUser;
import com.study.upms.dao.model.UpmsUserPermission;

/**
 * upms系统接口
 * 
 * @author KLP
 * @date 2017年12月28日下午4:41:18
 */
public interface UpmsApiService {

	/**
	 * 根据用户id获取所拥有的权限(用户和角色权限合集)
	 * 
	 * @author : KLP
	 * @param upmsUserId
	 * @return
	 */
	List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId);

	/**
	 * 根据用户id获取所拥有的权限(用户和角色权限合集)
	 * 
	 * @author : KLP
	 * @param upmsUserId
	 * @return
	 */
	List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId);

	/**
	 * 根据用户id获取所属的角色
	 * 
	 * @author : KLP
	 * @param upmsUserId
	 * @return
	 */
	List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId);

	/**
	 * 根据用户id获取所属的角色
	 * 
	 * @author : KLP
	 * @param upmsUserId
	 * @return
	 */
	List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId);

	/**
	 * 根据角色id获取所拥有的权限
	 * 
	 * @author : KLP
	 * @param upmsRoleId
	 * @return
	 */
	List<UpmsRolePermission> selectUpmsRolePermissionByUpmsRoleId(Integer upmsRoleId);

	/**
	 * 根据用户id获取所拥有的权限
	 * @author : KLP
	 * @param upmsUserId
	 * @return
	 */
	List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId);

	/**
	 * 根据条件获取系统数据
	 * 
	 * @author : KLP
	 * @param upmsSystemExample
	 * @return
	 */
	List<UpmsSystem> selectUpmsSystemByExample(UpmsSystemExample upmsSystemExample);

	/**
	 * 根据条件获取组织数据
	 * 
	 * @author : KLP
	 * @param upmsOrganizationExample
	 * @return
	 */
	List<UpmsOrganization> selectUpmsOranizationByExample(UpmsOrganizationExample upmsOrganizationExample);

	/**
	 * 根据username获取UpmsUser
	 * 
	 * @author : KLP
	 * @param username
	 * @return
	 */
	UpmsUser selectUpmsUserByUsername(String username);

	/**
	 * 写入操作日志
	 * 
	 * @author : KLP
	 * @param record
	 * @return
	 */
	int insertUpmsLogSelective(UpmsLog record);
}
