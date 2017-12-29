package com.study.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.study.common.base.BaseService;
import com.study.upms.dao.model.UpmsPermission;
import com.study.upms.dao.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* Created by shuzheng on 2017/12/26.
*/
public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {
	
	JSONArray getTreeByRoleId(Integer roleId);
	
	JSONArray getTreeByUserId(Integer userId,Byte type);
	
}