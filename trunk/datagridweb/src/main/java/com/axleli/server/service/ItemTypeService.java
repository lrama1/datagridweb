package com.axleli.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.axleli.server.dao.ItemTypeDAO;
import com.axleli.server.domain.ItemType;

@Service
public class ItemTypeService {

	@Autowired 
	ItemTypeDAO itemTypeDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testSave() throws Exception{
		System.out.println("Saving record...");
		ItemType itemType = new ItemType();
		itemType.setItemTypeId("12112" + System.currentTimeMillis());
		itemType.setItemTypeName("ols112" + System.currentTimeMillis());
		itemType.setItemTypeCode("ols112"+ System.currentTimeMillis());
		itemType.setItemTypeDesc("ols112");
		itemTypeDAO.save(itemType);
		//throw new Exception("test");
	}
	
}
