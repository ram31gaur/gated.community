package com.gated.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gated.model.Resident;
import com.gated.repo.ResidentRepo;

@Service
public class ResidentService {

	@Autowired private ResidentRepo residentRepo;
	
	public List<Resident> findAll(){
		List<Resident> it = residentRepo.findAll();
		List<Resident> residents = new ArrayList<Resident>();
		it.forEach(e -> residents.add(e));
		return residents;
	}
	
	public String saveResident(Resident resident){
		return "Successfully saved Resident Details: " + residentRepo.save(resident);
	}
	
	public List<Resident> searchResident(String name){
		return residentRepo.findByName(name);
	}
}
