package com.study.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsPermissionMapper;
import com.study.upms.dao.model.UpmsPermission;
import com.study.upms.dao.model.UpmsPermissionExample;

/**
* 降级实现UpmsPermissionService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsPermissionServiceMock.class);
	
	@Override
	public JSONArray getTreeByRoleId(Integer roleId) {
		LOGGER.info("UpmsPermissionServiceMock => getTreeByRoleId");
		return null;
	}

	@Override
	public JSONArray getTreeByUserId(Integer userId, Byte type) {
		LOGGER.info("UpmsPermissionServiceMock => getTreeByUserId");
		return null;
	}

}
