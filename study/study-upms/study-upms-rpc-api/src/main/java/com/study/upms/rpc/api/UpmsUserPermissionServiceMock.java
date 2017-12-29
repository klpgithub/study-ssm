package com.study.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.json.JSONArray;
import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsUserPermissionMapper;
import com.study.upms.dao.model.UpmsUserPermission;
import com.study.upms.dao.model.UpmsUserPermissionExample;

/**
* 降级实现UpmsUserPermissionService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsUserPermissionServiceMock extends BaseServiceMock<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserPermissionServiceMock.class);
	
	@Override
	public int permission(JSONArray datas, int id) {
		LOGGER.info("UpmsUserPermissionServiceMock => permission");
		return 0;
	}

}
