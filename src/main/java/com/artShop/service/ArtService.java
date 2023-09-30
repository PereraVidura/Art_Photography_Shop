package com.artShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artShop.entity.Art;
import com.artShop.repository.ArtRepository;

@Service
public class ArtService {
	
	@Autowired
	private ArtRepository aRepo;
	
	public void save(Art a) {
		aRepo.save(a);
	}
	
	public List<Art> getAllArts(){
		return aRepo.findAll();
	}
	
	public Art getArtById(int id) {
		return aRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		aRepo.deleteById(id);
	}

}
