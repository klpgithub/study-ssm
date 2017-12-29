package com.study.upms.rpc.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * 降级实现UpmsApiService接口
 * 
 * @author KLP
 * @date 2017年12月28日下午5:08:13
 */
public class UpmsApiServiceMock implements UpmsApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsApiServiceMock.class);

	@Override
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsPermissionByUpmsUserId");
		return null;
	}

	@Override
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsPermissionByUpmsUserIdByCache");
		return null;
	}

	@Override
	public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsRoleByUpmsUserId");
		return null;
	}

	@Override
	public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsRoleByUpmsUserIdByCache");
		return null;
	}

	@Override
	public List<UpmsRolePermission> selectUpmsRolePermissionByUpmsRoleId(Integer upmsRoleId) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsRolePermissionByUpmsRoleId");
		return null;
	}

	@Override
	public List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsUserPermissionByUpmsUserId");
		return null;
	}

	@Override
	public List<UpmsSystem> selectUpmsSystemByExample(UpmsSystemExample upmsSystemExample) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsSystemByExample");
		return null;
	}

	@Override
	public List<UpmsOrganization> selectUpmsOranizationByExample(UpmsOrganizationExample upmsOrganizationExample) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsOranizationByExample");
		return null;
	}

	@Override
	public UpmsUser selectUpmsUserByUsername(String username) {
		LOGGER.info("UpmsApiServiceMock => selectUpmsUserByUsername");
		return null;
	}

	@Override
	public int insertUpmsLogSelective(UpmsLog record) {
		LOGGER.info("UpmsApiServiceMock => insertUpmsLogSelective");
		return 0;
	}

}
