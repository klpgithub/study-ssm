package com.study.common.util;

import java.util.concurrent.locks.ReentrantLock;

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

}
