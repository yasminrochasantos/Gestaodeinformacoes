package com.izamim.typeBot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izamim.typeBot.entities.Category;
import com.izamim.typeBot.repositories.CategoryRepository;
import com.izamim.typeBot.services.exception.NotFound;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository rep;
	
	
	public List<Category> FindAll(){
		return rep.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> cat = rep.findById(id);
		return cat.orElseThrow(() -> new NotFound(id));
	}
	
	public Category insert(Category cat){
		return rep.save(cat);
	}
	
	public Category update (Long id, Category cat) {
		Category cate = rep.getReferenceById(id);
		cate.setName(cat.getName());
		cate.setDescription(cat.getDescription());
		rep.save(cate);
		return cate;
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
}
