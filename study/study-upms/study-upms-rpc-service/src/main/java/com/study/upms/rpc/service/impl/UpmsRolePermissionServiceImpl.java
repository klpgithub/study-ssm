package com.study.upms.rpc.service.impl;

import com.study.common.annotation.BaseService;
import com.study.common.base.BaseServiceImpl;
import com.study.upms.dao.mapper.UpmsRolePermissionMapper;
import com.study.upms.dao.model.UpmsRolePermission;
import com.study.upms.dao.model.UpmsRolePermissionExample;
import com.study.upms.rpc.api.UpmsRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRolePermissionService实现
* Created by shuzheng on 2017/12/26.
*/
@Service
@Transactional
@BaseService
public class UpmsRolePermissionServiceImpl extends BaseServiceImpl<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsRolePermissionServiceImpl.class);

    @Autowired
    UpmsRolePermissionMapper upmsRolePermissionMapper;

}