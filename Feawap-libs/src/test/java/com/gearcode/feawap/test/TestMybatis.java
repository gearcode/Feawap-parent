package com.gearcode.feawap.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gearcode.feawap.domain.Software;
import com.gearcode.feawap.domain.SoftwareWithBLOBs;
import com.gearcode.feawap.persistence.SoftwareMapper;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class TestMybatis {
	
	@Resource
	private SoftwareMapper softwareMapper;
	
	@Test
	public void testSelect() {
		List<Software> result = softwareMapper.selectByExampleWithRowbounds(null, new RowBounds());
		System.out.println(softwareMapper.countByExample(null));
		for (Software software : result) {
			System.out.println(software.getTitle());
		}
	}
	
	public void testInsert() {
		SoftwareWithBLOBs record = new SoftwareWithBLOBs(){{
			setTitle("test-" + System.currentTimeMillis());
		}};
		int rows = softwareMapper.insert(record);
		
		System.out.println("last insert id: " + record.getId());
	}
}
