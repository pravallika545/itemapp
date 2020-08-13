package com.dxctraining.dao;

import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemDaoImpl implements IItemDao{
	
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item findItemById(int id) {
        Item item=entityManager.find(Item.class,id);
        if(item==null){
            throw new ItemNotFoundException("Item not found for id="+id);
        }
        return item;
    }

    @Override
    public Item update(Item item) {
        item=entityManager.merge(item);
        return item;
    }

    @Override
    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }

    @Override
    public void remove(int id) {
     Item item= findItemById(id) ;
     entityManager.remove(item);
    }
}