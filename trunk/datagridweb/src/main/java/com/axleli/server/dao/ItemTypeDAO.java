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
public class ItemTypeDAO  {	

    @PersistenceContext
    private EntityManager em;

    public List<ItemType> findAllItemTypes() {
       Query query = em.createQuery("from ItemType as itemType");
       List<ItemType> resultList = query.getResultList();
       return resultList; 
    }
    
  
    @Transactional(propagation=Propagation.MANDATORY, rollbackFor=Exception.class)
    public void save(ItemType itemType){
    	em.persist(itemType);
    }
}