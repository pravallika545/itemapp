package com.dxctraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.dao.*;
import com.dxctraining.entities.*;
import com.dxctraining.exceptions.*;

@Transactional
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Override
	public Item findItemById(int id) {
		Item item=dao.findItemById(id);
		return item;
	}

	@Override
	public Item update(Item item) {
		validate(item);
		item=dao.update(item);
		return item;
	}

	private void validate(Object arg) {
		 if(arg==null){
	            throw new InvalidArgumentException("argument is null");
	        }
	    }
		
	@Override
	public Item save(Item item) {
		validate(item);
		item=dao.save(item);
		return item;
	}

	@Override
	public void remove(int id) {
		dao.remove(id);		
	}

}
