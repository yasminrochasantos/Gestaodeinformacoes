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

import com.izamim.typeBot.entities.Protocol;
import com.izamim.typeBot.services.ProtocolService;

@RestController
@RequestMapping(value = "/Protocols")
public class ProtocolResource {
	
	@Autowired
	private ProtocolService serv;

	@GetMapping
	public ResponseEntity<List<Protocol>> findAll(){
		List<Protocol> list = serv.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Protocol> insert(@RequestBody Protocol rm){
		serv.insert(rm);
		return ResponseEntity.ok().body(rm);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Protocol> FindById(@PathVariable Long id){
		Protocol rm = serv.findById(id);
		return ResponseEntity.ok().body(rm);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Protocol> delete(@PathVariable Long id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Protocol> update(@PathVariable Long id,@RequestBody Protocol rm){
		serv.update(id, rm);
		return ResponseEntity.ok().body(rm);
	}
}
