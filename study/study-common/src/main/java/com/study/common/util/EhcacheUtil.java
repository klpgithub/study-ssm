package com.study.common.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Ehcache工具类
 * 
 * @author KLP
 * @date 2017年12月18日下午2:16:54
 */
public class EhcacheUtil {

	/**
	 * 获取缓存
	 * 
	 * @author : KLP
	 * @param cacheName
	 * @return
	 */
	private static Cache getCache(String cacheName) {
		CacheManager cacheManager = CacheManager.getInstance();
		if (null == cacheManager) {
			return null;
		}
		Cache cache = cacheManager.getCache(cacheName);
		if (null == cache) {
			return null;
		}
		return cache;
	}

	/**
	 * 新增缓存记录
	 * 
	 * @author : KLP
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, String key, Object value) {
		Cache cache = getCache(cacheName);
		if (null != cache) {
			Element element = new Element(key, value);
			cache.put(element);
		}
	}

	/**
	 * 删除缓存记录
	 * 
	 * @author : KLP
	 * @param cacheName
	 * @param key
	 */
	public static boolean remove(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		if (null == cache) {
			return false;
		}
		return cache.remove(key);
	}

	/**
	 * 删除全部缓存记录
	 * 
	 * @author : KLP
	 * @param cacheName
	 */
	public static void removeAll(String cacheName) {
		Cache cache = getCache(cacheName);
		if (null != cache) {
			cache.removeAll();
		}
	}

	/**
	 * 获取缓存记录
	 * 
	 * @author : KLP
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		if (null == cache) {
			return null;
		}
		Element element = cache.get(key);
		if (null == element) {
			return null;
		}
		return element.getObjectValue();
	}

}
