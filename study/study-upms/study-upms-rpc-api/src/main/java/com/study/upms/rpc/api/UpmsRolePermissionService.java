package com.study.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.study.common.base.BaseService;
import com.study.upms.dao.model.UpmsRolePermission;
import com.study.upms.dao.model.UpmsRolePermissionExample;

/**
* UpmsRolePermissionService接口
* Created by shuzheng on 2017/12/26.
*/
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {
	
	/**
	 * 角色权限
	 * @author : KLP
	 * @param data权限数据
	 * @param id 角色id
	 * @return
	 */
	int rolePermission(JSONArray data,int id);
}