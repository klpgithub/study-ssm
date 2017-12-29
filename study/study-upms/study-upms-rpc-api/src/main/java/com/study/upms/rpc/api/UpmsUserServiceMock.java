package com.study.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsUserMapper;
import com.study.upms.dao.model.UpmsUser;
import com.study.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserServiceMock.class);
	
	@Override
	public UpmsUser createUser(UpmsUser upmsUser) {
		LOGGER.info("UpmsUserServiceMock => createUser");
		return null;
	}

}
