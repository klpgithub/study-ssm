package com.study.upms.rpc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
import com.study.upms.dao.model.UpmsSystem;
import com.study.upms.dao.model.UpmsSystemExample;
import com.study.upms.dao.model.UpmsUser;
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
	
	
	@Override
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UpmsPermission> selectUpmsRolePermissionByUpmsRoleId(Integer upmsRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UpmsPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UpmsSystem> selectUpmsSystemByExample(UpmsSystemExample upmsSystemExample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UpmsOrganization> selectUpmsOranizationByExample(UpmsOrganizationExample upmsOrganizationExample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpmsUser selectUpmsUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUpmsLogSelective(UpmsLog record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
