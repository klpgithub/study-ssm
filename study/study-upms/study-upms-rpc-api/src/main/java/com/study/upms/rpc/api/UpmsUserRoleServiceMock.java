package com.study.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsUserRoleMapper;
import com.study.upms.dao.model.UpmsUserRole;
import com.study.upms.dao.model.UpmsUserRoleExample;

/**
* 降级实现UpmsUserRoleService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsUserRoleServiceMock extends BaseServiceMock<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserRoleServiceMock.class);
	
	@Override
	public int role(String[] roleIds, int id) {
		LOGGER.info("UpmsUserRoleServiceMock => role");
		return 0;
	}

}
