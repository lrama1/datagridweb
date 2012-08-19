package com.datagrid.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml", "/test-ds.xml" })
public class ItemTypeDAOTests {

	@Autowired
	ItemTypeDAO itemTypeDAO;
	
	@Test
	public void testNumberOfItemTypes(){
		assertEquals(7, itemTypeDAO.findAll(0).size());
	}
	
	@Test
	public void testVerifyItemTypesHaveAttributeTypes(){
		List<ItemType> itemTypes = itemTypeDAO.findAll(0);
		for(ItemType itemType: itemTypes){
			assertTrue("Item Type: " + itemType.getItemTypeName() + " do not have itemAttributeTypes defined"
					,itemType.getItemAttributeTypesForItemTypeId().size() > 0);
		}
	}
	
}
