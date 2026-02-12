package com.izamim.typeBot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.izamim.typeBot.entities.Category;
import com.izamim.typeBot.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService serv;

	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = serv.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody Category cat){
		serv.insert(cat);
		return ResponseEntity.ok().body(cat);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> FindById(@PathVariable Long id){
		Category cat = serv.findById(id);
		return ResponseEntity.ok().body(cat);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Category> delete(@PathVariable Long id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Category> update(@PathVariable Long id,@RequestBody Category cat){
		serv.update(id, cat);
		return ResponseEntity.ok().body(cat);
	}
}
