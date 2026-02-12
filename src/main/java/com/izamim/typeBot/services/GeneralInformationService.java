package com.izamim.typeBot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izamim.typeBot.entities.GeneralInformation;
import com.izamim.typeBot.repositories.GeneralInformationRepository;
import com.izamim.typeBot.services.exception.NotFound;

@Service
public class GeneralInformationService {

	@Autowired
	private GeneralInformationRepository rep;	
	
	public List<GeneralInformation> FindAll(){
		return rep.findAll();
	}
	
	public GeneralInformation findById(Long id) {
		Optional<GeneralInformation> gi = rep.findById(id);
		return gi.orElseThrow(() -> new NotFound(id));
	}
	
	public GeneralInformation insert(GeneralInformation gi){
		return rep.save(gi);
	}
	
	public GeneralInformation update (Long id, GeneralInformation gi) {
		GeneralInformation gil = rep.getReferenceById(id);
		gil.setDescription(gi.getDescription());
		gil.setCategory(gi.getCategory());
		gil.setTitle(gi.getTitle());
		rep.save(gil);
		return gil;
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
}
