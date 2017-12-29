package com.study.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsSystemMapper;
import com.study.upms.dao.model.UpmsSystem;
import com.study.upms.dao.model.UpmsSystemExample;

/**
* 降级实现UpmsSystemService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsSystemServiceMock.class);
	
	@Override
	public UpmsSystem selectUpmsSystemByName(String name) {
		LOGGER.info("UpmsSystemServiceMock => selectUpmsSystemByName");
		return null;
	}

}
