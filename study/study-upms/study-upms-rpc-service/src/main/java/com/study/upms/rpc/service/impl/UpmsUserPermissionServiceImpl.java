package com.study.upms.rpc.service.impl;

import com.alibaba.dubbo.common.json.JSONArray;
import com.study.common.annotation.BaseService;
import com.study.common.base.BaseServiceImpl;
import com.study.upms.dao.mapper.UpmsUserPermissionMapper;
import com.study.upms.dao.model.UpmsUserPermission;
import com.study.upms.dao.model.UpmsUserPermissionExample;
import com.study.upms.rpc.api.UpmsUserPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserPermissionService实现
* Created by shuzheng on 2017/12/26.
*/
@Service
@Transactional
@BaseService
public class UpmsUserPermissionServiceImpl extends BaseServiceImpl<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserPermissionServiceImpl.class);

    @Autowired
    UpmsUserPermissionMapper upmsUserPermissionMapper;

	@Override
	public int permission(JSONArray datas, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}