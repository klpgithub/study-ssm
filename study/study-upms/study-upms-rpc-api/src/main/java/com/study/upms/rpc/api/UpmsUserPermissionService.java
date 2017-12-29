package com.study.upms.rpc.api;

import com.alibaba.dubbo.common.json.JSONArray;
import com.study.common.base.BaseService;
import com.study.upms.dao.model.UpmsUserPermission;
import com.study.upms.dao.model.UpmsUserPermissionExample;

/**
* UpmsUserPermissionService接口
* Created by shuzheng on 2017/12/26.
*/
public interface UpmsUserPermissionService extends BaseService<UpmsUserPermission, UpmsUserPermissionExample> {
	
	/**
	 * 用户权限
	 * @author : KLP
	 * @param datas 权限数据
	 * @param id 用户id
	 * @return
	 */
	int permission(JSONArray datas,int id);
}