package com.izamim.typeBot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izamim.typeBot.entities.Protocol;
import com.izamim.typeBot.repositories.ProtocolRepository;
import com.izamim.typeBot.services.exception.NotFound;

@Service
public class ProtocolService {

	@Autowired
	private ProtocolRepository rep;
	
	
	public List<Protocol> FindAll(){
		return rep.findAll();
	}
	
	public Protocol findById(Long id) {
		Optional<Protocol> pr = rep.findById(id);
		return pr.orElseThrow(() -> new NotFound(id));
	}
	
	public Protocol insert(Protocol pr){
		return rep.save(pr);
	}
	
	public Protocol update (Long id, Protocol pr) {
		Protocol prl = rep.getReferenceById(id);
		prl.setName(pr.getName());
		prl.setDescription(pr.getDescription());
		prl.setCategory(pr.getCategory());
		rep.save(prl);
		return prl;
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
}
