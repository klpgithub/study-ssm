package com.study.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC工具类
 * 
 * @author KLP
 * @date 2017年12月18日下午3:48:09
 */
public class JDBCUtil {

	// 定义数据库的链接
	private Connection conn;
	// 定义sql语句的执行对象
	private PreparedStatement ps;
	// 定义查询返回的结果集合
	private ResultSet rs;

	// 初始化
	public JDBCUtil(String driver, String url, String username, String password) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 更新数据
	public boolean updateByParam(String sql, List param) throws SQLException {
		// 影响行数
		int result = -1;
		ps = conn.prepareStatement(sql);
		int index = 1;
		if (null != param && !param.isEmpty()) {
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(index++, param.get(i));
			}
		}
		result = ps.executeUpdate();
		return result > 0 ? true : false;
	}

	// 查询多条记录
	public List<Map> selectByParams(String sql, List param) throws Exception {
		List<Map> list = new ArrayList<>();
		int index = 1;
		ps = conn.prepareStatement(sql);
		if (null != param && !param.isEmpty()) {
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(index++, param.get(i));
			}
		}
		rs = ps.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int colsLen = metaData.getColumnCount();
		while (rs.next()) {
			Map map = new HashMap(colsLen);
			for (int i = 0; i < colsLen; i++) {
				String columnName = metaData.getColumnName(i + 1);
				Object columnValue = rs.getObject(columnName);
				if (null == columnValue) {
					columnValue = "";
				}
				map.put(columnName, columnValue);
			}
			list.add(map);
		}
		return list;
	}

	// 释放连接
	public void release() {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != ps) {
				ps.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("释放数据库连接");
	}

}
