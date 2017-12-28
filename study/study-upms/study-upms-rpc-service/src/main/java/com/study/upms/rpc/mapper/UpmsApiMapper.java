package com.study.upms.rpc.mapper;

import com.study.upms.dao.model.UpmsPermission;
import com.study.upms.dao.model.UpmsRole;
import com.sun.tools.javac.util.List;

/**
 * 用户VOMapper
 * 
 * @author KLP
 * @date 2017年12月28日下午5:39:19
 */
public interface UpmsApiMapper {

	/**
	 * 根据用户id获取所拥有的权限
	 * 
	 * @author : KLP
	 * @param upmsUserId
	 * @return
	 */
	List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId);

	/**
	 * 根据用户id获取所属的角色
	 * 
	 * @author : KLP
	 * @param upmsUserId
	 * @return
	 */
	List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId);
}
