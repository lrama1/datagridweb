package com.datagrid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datagrid.dao.IItemTypeDAO;
import com.datagrid.dao.ItemType;
import com.datagrid.dao.ItemTypeDAO;

@Controller
public class HomeController {
	@Autowired
	ItemTypeDAO itemTypeDAO;
	
	@RequestMapping("/home")
	public String showFirstHomePage(){
		List<ItemType> itemTypes = itemTypeDAO.findAll(0);
		System.out.println(itemTypes.size());
		return "index.jsp";
	}
}
