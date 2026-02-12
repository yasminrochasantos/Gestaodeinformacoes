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

import com.izamim.typeBot.entities.GeneralInformation;
import com.izamim.typeBot.services.GeneralInformationService;

@RestController
@RequestMapping(value = "/GeneralInformations")
public class GeneralInformationResource {
	
	@Autowired
	private GeneralInformationService serv;

	@GetMapping
	public ResponseEntity<List<GeneralInformation>> findAll(){
		List<GeneralInformation> list = serv.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<GeneralInformation> insert(@RequestBody GeneralInformation gene){
		serv.insert(gene);
		return ResponseEntity.ok().body(gene);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GeneralInformation> FindById(@PathVariable Long id){
		GeneralInformation rm = serv.findById(id);
		return ResponseEntity.ok().body(rm);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<GeneralInformation> delete(@PathVariable Long id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<GeneralInformation> update(@PathVariable Long id,@RequestBody GeneralInformation gene){
		serv.update(id, gene);
		return ResponseEntity.ok().body(gene);
	}
}
