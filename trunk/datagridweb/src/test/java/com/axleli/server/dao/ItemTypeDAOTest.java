package com.axleli.server.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-ds.xml", "/test-applicationContext.xml"})
public class ItemTypeDAOTest {

	@Autowired
	ItemTypeDAO itemTypeDAO;
	
	@Test
	public void testNumberOfItemTypes(){
		assertEquals(7, itemTypeDAO.findAll().size());
	}
}
