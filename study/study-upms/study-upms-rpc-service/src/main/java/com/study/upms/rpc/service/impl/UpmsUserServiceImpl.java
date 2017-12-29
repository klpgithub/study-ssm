package com.study.upms.rpc.service.impl;

import com.study.common.annotation.BaseService;
import com.study.common.base.BaseServiceImpl;
import com.study.upms.dao.mapper.UpmsUserMapper;
import com.study.upms.dao.model.UpmsUser;
import com.study.upms.dao.model.UpmsUserExample;
import com.study.upms.rpc.api.UpmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserService实现
* Created by shuzheng on 2017/12/26.
*/
@Service
@Transactional
@BaseService
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserServiceImpl.class);

    @Autowired
    UpmsUserMapper upmsUserMapper;

	@Override
	public UpmsUser createUser(UpmsUser upmsUser) {
		// TODO Auto-generated method stub
		return null;
	}

}