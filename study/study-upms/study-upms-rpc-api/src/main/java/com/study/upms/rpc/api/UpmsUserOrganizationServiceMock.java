package com.study.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.study.upms.dao.model.UpmsUserOrganization;
import com.study.upms.dao.model.UpmsUserOrganizationExample;

/**
* 降级实现UpmsUserOrganizationService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsUserOrganizationServiceMock extends BaseServiceMock<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserOrganizationServiceMock.class);
	
	@Override
	public int organization(String[] organizationIds, int id) {
		LOGGER.info("UpmsUserOrganizationServiceMock => organization");
		return 0;
	}

}
