package com.study.common.util;

import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis 工具类
 * 
 * @author KLP 2017年12月19日下午11:32:06
 */
public class RedisUtil {

	protected static ReentrantLock lockPool = new ReentrantLock();
	protected static ReentrantLock lockJedis = new ReentrantLock();

	private static Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

	// Redis服务器ip
	private static String IP = PropertiesFileUtil.getInstance("redis").get("master.redis.ip");

	// Redis的端口
	private static int PORT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.port");

	// 访问密码
	private static String PASSWORD = AESUtil
			.aesDecode(PropertiesFileUtil.getInstance("redis").get("master.redis.password"));

	// 可用连接实例的最大数目,默认值为8
	// 如果赋值为-1,则表示不限制,如果pool已经 分配了maxActive个jedis实例,则此时pool的状态为exhausted(耗尽)
	private static int MAX_ACTIVE = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_active");

	// 空中一个pool最多有多少撞他为idle(空闲)的jedis实例,默认为8
	private static int MAX_IDLE = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_idle");

	// 等待可用连接的最大时间,单位毫秒,默认值为-1,表示不超时,如果超过等待时间,则直接抛出JedisConnectionException
	private static int MAX_WAIT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_wait");

	// 超时时间
	private static int TIMEOUT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.timeout");

	// 在borrow一个jedis实例时,是否提前进行validate操作,如果为true,则得到的jedis实例均是可用的
	private static boolean TEST_ON_BORROW = false;

	private static JedisPool jedisPool = null;

	/**
	 * redis 过期时间 以秒为单位
	 */
	// 一小时
	private final static int EXRP_HOUR = 60 * 60;
	// 一天
	private final static int EXRP_DAT = 60 * 60 * 24;
	// 一个月
	private final static int EXRP_MONTH = 60 * 60 * 24 * 30;

	/**
	 * 初始化redis连接池
	 */
	private static void initialPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, IP, PORT, TIMEOUT);
		} catch (Exception e) {
			LOGGER.error("First create JedisPool error :" + e);
		}
	}

	/**
	 * 在多线程环境同步初始化
	 */
	private static synchronized void poolInit() {
		if (null == jedisPool) {
			initialPool();
		}
	}

	/**
	 * 同步获取jedis实例
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		poolInit();
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			try {
				jedis.auth(PASSWORD);
			} catch (Exception e) {
			}
		} catch (Exception e) {
			LOGGER.error("get jedis error : " + e);
		}
		return jedis;
	}

	/**
	 * 设置 String
	 * 
	 * @author : KLP
	 * @param key
	 * @param value
	 */
	public synchronized static void set(String key, String value) {
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("set key error : " + e);
		}
	}

	/**
	 * 设置 byte[]
	 * 
	 * @author : KLP
	 * @param key
	 * @param value
	 */
	public synchronized static void set(byte[] key, byte[] value) {
		try {
			Jedis jedis = getJedis();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("set key error : " + e);
		}
	}

	/**
	 * 设置String过期时间
	 * 
	 * @author : KLP
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public synchronized static void set(String key, String value, int seconds) {
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			Jedis jedis = getJedis();
			jedis.setex(key, seconds, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("set keyex error : " + e);
		}
	}

	/**
	 * 设置byte过期时间
	 * 
	 * @author : KLP
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public synchronized static void set(byte[] key, byte[] value, int seconds) {
		try {
			Jedis jedis = getJedis();
			jedis.setex(key, seconds, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("set keyex error : " + e);
		}
	}

	/**
	 * 获取string值
	 * 
	 * @author : KLP
	 * @param key
	 * @return
	 */
	public synchronized static String get(String key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		String value = jedis.get(key);
		jedis.close();
		return value;
	}

	/**
	 * 获取byte值
	 * 
	 * @author : KLP
	 * @param key
	 * @return
	 */
	public synchronized static byte[] get(byte[] key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		byte[] value = jedis.get(key);
		jedis.close();
		return value;
	}

	/**
	 * 删除值
	 * 
	 * @author : KLP
	 * @param key
	 */
	public synchronized static void remove(String key) {
		try {
			Jedis jedis = getJedis();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Remove keyex error : " + e);
		}
	}

	/**
	 * 删除值
	 * 
	 * @author : KLP
	 * @param key
	 */
	public synchronized static void remove(byte[] key) {
		try {
			Jedis jedis = getJedis();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("Remove keyex error : " + e);
		}
	}

	/**
	 * lpush
	 * 
	 * @author : KLP
	 * @param key
	 * @param strings
	 */
	public synchronized static void lpush(String key, String... strings) {
		try {
			Jedis jedis = getJedis();
			jedis.lpush(key, strings);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("lpush error : " + e);
		}
	}

	/**
	 * lrem
	 * 
	 * @author : KLP
	 * @param key
	 * @param count
	 * @param value
	 */
	public synchronized static void lrem(String key, long count, String value) {
		try {
			Jedis jedis = getJedis();
			jedis.lrem(key, count, value);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("lrem error : " + e);
		}
	}

	/**
	 * sadd
	 * 
	 * @author : KLP
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public synchronized static void sadd(String key, String value, int seconds) {
		try {
			Jedis jedis = getJedis();
			jedis.sadd(key, value);
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			LOGGER.error("sadd error : " + e);
		}
	}

	/**
	 * incr
	 * 
	 * @author : KLP
	 * @param key
	 * @return
	 */
	public synchronized static Long incr(String key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		Long value = jedis.incr(key);
		jedis.close();
		return value;
	}

	/**
	 * decr
	 * 
	 * @author : KLP
	 * @param key
	 * @return
	 */
	public synchronized static Long decr(String key) {
		Jedis jedis = getJedis();
		if (null == jedis) {
			return null;
		}
		Long value = jedis.decr(key);
		jedis.close();
		return value;
	}

}
