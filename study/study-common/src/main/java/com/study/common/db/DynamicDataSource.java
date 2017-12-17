package com.study.common.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态数据源 (数据源切换)
 * 
 * @author KLP 2017年12月17日下午6:23:38
 */
public class DynamicDataSource {

	private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

	protected Object determineCurrentLookupKey() {
		String dataSource = getDataSource();
		LOGGER.info("当前操作使用的数据源:{}", dataSource);
		return dataSource;
	}

	/**
	 * 设置数据源
	 */
	public static void setDataSource(String dataSource) {
		CONTEXT_HOLDER.set(dataSource);
	}

	/**
	 * 获取数据源
	 * 
	 * @return
	 */
	public static String getDataSource() {
		String dataSource = CONTEXT_HOLDER.get();
		// 如果没有指定数据源,使用默认数据源
		if (null == dataSource) {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getDefault());
		}
		return CONTEXT_HOLDER.get();
	}

	/**
	 * 清除数据源
	 */
	public static void clearDataSource() {
		CONTEXT_HOLDER.remove();
	}

}
