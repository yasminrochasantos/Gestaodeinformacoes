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

import com.izamim.typeBot.entities.Room;
import com.izamim.typeBot.services.RoomService;

@RestController
@RequestMapping(value = "/rooms")
public class RoomResource {
	
	@Autowired
	private RoomService serv;

	@GetMapping
	public ResponseEntity<List<Room>> findAll(){
		List<Room> list = serv.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Room> insert(@RequestBody Room rm){
		serv.insert(rm);
		return ResponseEntity.ok().body(rm);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Room> FindById(@PathVariable Long id){
		Room rm = serv.findById(id);
		return ResponseEntity.ok().body(rm);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Room> delete(@PathVariable Long id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Room> update(@PathVariable Long id,@RequestBody Room rm){
		serv.update(id, rm);
		return ResponseEntity.ok().body(rm);
	}
}
