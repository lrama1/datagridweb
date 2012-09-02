package com.axleli.web.controller;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axleli.server.dao.ItemTypeDAO;
import com.axleli.server.domain.ItemType;
import com.axleli.server.service.ItemTypeService;


@Controller
public class HomeController {

	@Autowired
	ItemTypeDAO itemTypeDAO;
	
	@Autowired
	ItemTypeService itemTypeService;
	
	@RequestMapping("/home")
	public String showHomePage(){		
		try {
			itemTypeService.testSave();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Number of itemTypes:" + itemTypeDAO.findAllItemTypes().size());
		return "/WEB-INF/jsps/home.jsp";
	}
	

}
