/*
 * Created on 3 avr. 2014 ( Time 19:39:43 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.Workgroup;
import org.demo.bean.jpa.WorkgroupEntity;
import org.demo.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class WorkgroupServiceMapperTest {

	private WorkgroupServiceMapper workgroupServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		workgroupServiceMapper = new WorkgroupServiceMapper();
		workgroupServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'WorkgroupEntity' to 'Workgroup'
	 * @param workgroupEntity
	 */
	@Test
	public void testMapWorkgroupEntityToWorkgroup() {
		// Given
		WorkgroupEntity workgroupEntity = new WorkgroupEntity();
		workgroupEntity.setName(mockValues.nextString(40));
		workgroupEntity.setDescription(mockValues.nextString(600));
		workgroupEntity.setCreationDate(mockValues.nextDate());
		
		// When
		Workgroup workgroup = workgroupServiceMapper.mapWorkgroupEntityToWorkgroup(workgroupEntity);
		
		// Then
		assertEquals(workgroupEntity.getName(), workgroup.getName());
		assertEquals(workgroupEntity.getDescription(), workgroup.getDescription());
		assertEquals(workgroupEntity.getCreationDate(), workgroup.getCreationDate());
	}
	
	/**
	 * Test : Mapping from 'Workgroup' to 'WorkgroupEntity'
	 */
	@Test
	public void testMapWorkgroupToWorkgroupEntity() {
		// Given
		Workgroup workgroup = new Workgroup();
		workgroup.setName(mockValues.nextString(40));
		workgroup.setDescription(mockValues.nextString(600));
		workgroup.setCreationDate(mockValues.nextDate());

		WorkgroupEntity workgroupEntity = new WorkgroupEntity();
		
		// When
		workgroupServiceMapper.mapWorkgroupToWorkgroupEntity(workgroup, workgroupEntity);
		
		// Then
		assertEquals(workgroup.getName(), workgroupEntity.getName());
		assertEquals(workgroup.getDescription(), workgroupEntity.getDescription());
		assertEquals(workgroup.getCreationDate(), workgroupEntity.getCreationDate());
	}

}