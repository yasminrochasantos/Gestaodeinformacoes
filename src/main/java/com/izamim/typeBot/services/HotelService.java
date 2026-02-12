package com.izamim.typeBot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izamim.typeBot.entities.Hotel;
import com.izamim.typeBot.repositories.HotelRepository;
import com.izamim.typeBot.services.exception.NotFound;

@Service
public class HotelService {

	@Autowired
	private HotelRepository rep;
	
	
	public List<Hotel> FindAll(){
		return rep.findAll();
	}
	
	public Hotel findById(Long id) {
		Optional<Hotel> ht = rep.findById(id);
		return ht.orElseThrow(() -> new NotFound(id));
	}
	
	public Hotel insert(Hotel ht){
		return rep.save(ht);
	}
	
	public Hotel update (Long id, Hotel ht) {
		Hotel htl = rep.getReferenceById(id);
		htl.setName(ht.getName());
		htl.setDescription(ht.getDescription());
		htl.setCategory(ht.getCategory());
		rep.save(htl);
		return htl;
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
}
