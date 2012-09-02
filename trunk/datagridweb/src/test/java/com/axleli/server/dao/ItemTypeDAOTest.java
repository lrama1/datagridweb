package com.axleli.server.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.axleli.server.domain.ItemType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-ds.xml", "/test-applicationContext.xml"})
public class ItemTypeDAOTest {

	@Autowired
	ItemTypeDAO itemTypeDAO;
	
	@Test
	public void testNumberOfItemTypes(){
		assertEquals(7, itemTypeDAO.findAllItemTypes().size());
	}
}
