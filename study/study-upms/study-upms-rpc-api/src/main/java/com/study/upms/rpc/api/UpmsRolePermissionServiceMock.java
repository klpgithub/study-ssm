package com.study.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsRolePermissionMapper;
import com.study.upms.dao.model.UpmsRolePermission;
import com.study.upms.dao.model.UpmsRolePermissionExample;

/**
* 降级实现UpmsRolePermissionService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsRolePermissionServiceMock extends BaseServiceMock<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRolePermissionServiceMock.class);

	@Override
	public int rolePermission(JSONArray data, int id) {
		LOGGER.info("UpmsRolePermissionServiceMock => rolePermission");
		return 0;
	}

}
