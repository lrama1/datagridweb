package com.axleli.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.axleli.server.domain.ItemType;

@Repository
public class ItemTypeDAO extends AbstractJpaDAO<ItemType> {	

    //@PersistenceContext
    //private EntityManager entityManager;
	public ItemTypeDAO(){
		setClazz(ItemType.class);
	}
	

}