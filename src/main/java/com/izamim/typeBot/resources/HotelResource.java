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

import com.izamim.typeBot.entities.Hotel;
import com.izamim.typeBot.services.HotelService;

@RestController
@RequestMapping(value = "/hotels")
public class HotelResource {
	
	@Autowired
	private HotelService serv;

	@GetMapping
	public ResponseEntity<List<Hotel>> findAll(){
		List<Hotel> list = serv.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Hotel> insert(@RequestBody Hotel ht){
		serv.insert(ht);
		return ResponseEntity.ok().body(ht);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Hotel> FindById(@PathVariable Long id){
		Hotel ht = serv.findById(id);
		return ResponseEntity.ok().body(ht);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Hotel> delete(@PathVariable Long id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Hotel> update(@PathVariable Long id,@RequestBody Hotel ht){
		serv.update(id, ht);
		return ResponseEntity.ok().body(ht);
	}
}
