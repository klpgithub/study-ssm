package com.study.upms.rpc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.study.upms.dao.mapper.UpmsLogMapper;
import com.study.upms.dao.mapper.UpmsOrganizationMapper;
import com.study.upms.dao.mapper.UpmsRolePermissionMapper;
import com.study.upms.dao.mapper.UpmsSystemMapper;
import com.study.upms.dao.mapper.UpmsUserMapper;
import com.study.upms.dao.mapper.UpmsUserPermissionMapper;
import com.study.upms.dao.model.UpmsLog;
import com.study.upms.dao.model.UpmsOrganization;
import com.study.upms.dao.model.UpmsOrganizationExample;
import com.study.upms.dao.model.UpmsPermission;
import com.study.upms.dao.model.UpmsRole;
import com.study.upms.dao.model.UpmsRolePermission;
import com.study.upms.dao.model.UpmsRolePermissionExample;
import com.study.upms.dao.model.UpmsSystem;
import com.study.upms.dao.model.UpmsSystemExample;
import com.study.upms.dao.model.UpmsUser;
import com.study.upms.dao.model.UpmsUserExample;
import com.study.upms.dao.model.UpmsUserPermission;
import com.study.upms.dao.model.UpmsUserPermissionExample;
import com.study.upms.rpc.api.UpmsApiService;
import com.study.upms.rpc.mapper.UpmsApiMapper;

/**
 * UpmsApiService实现
 * 
 * @author KLP
 * @date 2017年12月28日下午5:16:45
 */
public class UpmsApiServiceImpl implements UpmsApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsApiServiceImpl.class);

	@Autowired
	UpmsUserMapper upmsUserMapper;

	@Autowired
	UpmsApiMapper upmsApiMapper;

	@Autowired
	UpmsUserPermissionMapper upmsUserPermissionMapper;

	@Autowired
	UpmsRolePermissionMapper upmsRolePermissionMapper;

	@Autowired
	UpmsSystemMapper upmsSystemMapper;

	@Autowired
	UpmsOrganizationMapper upmsOrganizationMapper;

	@Autowired
	UpmsLogMapper upmsLogMapper;

	/**
	 * 根据用户id获取所拥有的权限
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
		// 用户不存在或锁定状态
		UpmsUser upmsUser = upmsUserMapper.selectByPrimaryKey(upmsUserId);
		if (null == upmsUser || 1 == upmsUser.getLocked()) {
			LOGGER.info("selectUpmsPermissionByUpmsUserId: upmsUserId = {}", upmsUserId);
			return null;
		}
		List<UpmsPermission> upmsPermissions = upmsApiMapper.selectUpmsPermissionByUpmsUserId(upmsUserId);
		return upmsPermissions;
	}

	/**
	 * 根据用户id获取所拥有的权限
	 * 
	 * @author KLP
	 *
	 */
	@Override
	@Cacheable(value = "study-upms-rpc-service-ehcache", key = "'selectUpmsPermissionByUpmsUserId_' + #upmsUserId")
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
		return selectUpmsPermissionByUpmsUserId(upmsUserId);
	}

	/**
	 * 根据用户id获取所属的角色
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
		// 用户不存在或锁定状态
		UpmsUser upmsUser = upmsUserMapper.selectByPrimaryKey(upmsUserId);
		if (null == upmsUser || 1 == upmsUser.getLocked()) {
			LOGGER.info("selectUpmsPermissionByUpmsUserId: upmsUserId = {}", upmsUserId);
			return null;
		}
		List<UpmsRole> upmsRoles = upmsApiMapper.selectUpmsRoleByUpmsUserId(upmsUserId);
		return upmsRoles;
	}

	/**
	 * 根据用户id获取所属的角色
	 * 
	 * @author KLP
	 *
	 */
	@Override
	@Cacheable(value = "study-upms-rpc-service-ehcache", key = "'selectUpmsRoleByUpmsUserId_' + #upmsUserId")
	public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
		return selectUpmsRoleByUpmsUserId(upmsUserId);
	}

	/**
	 * 根据角色id获取所拥有的权限
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public List<UpmsRolePermission> selectUpmsRolePermissionByUpmsRoleId(Integer upmsRoleId) {
		UpmsRolePermissionExample upmsRolePermissionExample = new UpmsRolePermissionExample();
		upmsRolePermissionExample.createCriteria().andRoleIdEqualTo(upmsRoleId);
		List<UpmsRolePermission> upmsRolePermissions = upmsRolePermissionMapper
				.selectByExample(upmsRolePermissionExample);
		return upmsRolePermissions;
	}

	/**
	 * 根据用户id获取所拥有的权限
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId) {
		UpmsUserPermissionExample upmsUserPermissionExample = new UpmsUserPermissionExample();
		upmsUserPermissionExample.createCriteria().andUserIdEqualTo(upmsUserId);
		List<UpmsUserPermission> upmsUserPermissions = upmsUserPermissionMapper
				.selectByExample(upmsUserPermissionExample);
		return upmsUserPermissions;
	}

	/**
	 * 根据条件获取系统数据
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public List<UpmsSystem> selectUpmsSystemByExample(UpmsSystemExample upmsSystemExample) {
		return upmsSystemMapper.selectByExample(upmsSystemExample);
	}

	/**
	 * 根据条件获取组织数据
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public List<UpmsOrganization> selectUpmsOranizationByExample(UpmsOrganizationExample upmsOrganizationExample) {
		return upmsOrganizationMapper.selectByExample(upmsOrganizationExample);
	}

	/**
	 * 根据username获取UpmsUser
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public UpmsUser selectUpmsUserByUsername(String username) {
		UpmsUserExample upmsUserExample = new UpmsUserExample();
		upmsUserExample.createCriteria().andUsernameEqualTo(username);
		List<UpmsUser> upmsUsers = upmsUserMapper.selectByExample(upmsUserExample);
		if (null != upmsUsers && upmsUsers.size() > 0) {
			return upmsUsers.get(0);
		}
		return null;
	}

	/**
	 * 写入操作日志
	 * 
	 * @author KLP
	 *
	 */
	@Override
	public int insertUpmsLogSelective(UpmsLog record) {
		return upmsLogMapper.insert(record);
	}

}
