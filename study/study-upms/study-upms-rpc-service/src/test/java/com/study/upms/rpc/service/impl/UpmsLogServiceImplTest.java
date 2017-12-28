package com.study.upms.rpc.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.study.upms.dao.model.UpmsLog;
import com.study.upms.dao.model.UpmsLogExample;
import com.study.upms.rpc.api.UpmsLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/*.xml" })
@Rollback(value=true)
@Transactional(transactionManager = "transactionManager")
public class UpmsLogServiceImplTest {

	@Autowired
	private UpmsLogService upmsLogService;

	@Test
	public void testCountByExample() {
		List<UpmsLog> list = upmsLogService.selectByExample(new UpmsLogExample());
		System.out.println(list);
	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExampleWithBLOBs() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExampleWithBLOBsForStartPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExampleForStartPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExampleWithBLOBsForOffsetPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExampleForOffsetPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectFirstByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectFirstByExampleWithBLOBs() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExampleWithBLOBs() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeyWithBLOBs() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKeys() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitMapper() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMapperClass() {
		fail("Not yet implemented");
	}

}
