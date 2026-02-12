package com.izamim.typeBot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izamim.typeBot.entities.Room;
import com.izamim.typeBot.repositories.RoomRepository;
import com.izamim.typeBot.services.exception.NotFound;

@Service
public class RoomService {

	@Autowired
	private RoomRepository rep;
	
	
	public List<Room> FindAll(){
		return rep.findAll();
	}
	
	public Room findById(Long id) {
		Optional<Room> rm = rep.findById(id);
		return rm.orElseThrow(() -> new NotFound(id));
	}
	
	public Room insert(Room rm){
		return rep.save(rm);
	}
	
	public Room update (Long id, Room rm) {
		Room rom = rep.getReferenceById(id);
		rom.setNumber(rm.getNumber());
		rom.setDescription(rm.getDescription());
		rom.setCheckin(rm.getCheckin());
		rom.setCheckout(rm.getCheckout());
		rom.setHotel(rm.getHotel());
		rep.save(rom);
		return rom;
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
}
