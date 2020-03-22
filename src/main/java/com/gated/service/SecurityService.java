package com.gated.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gated.model.Security;
import com.gated.repo.SecurityRepo;

@Service
public class SecurityService {

	@Autowired private SecurityRepo securityRepo;
	
	public List<Security> findAll(){
		List<Security> it = securityRepo.findAll();
		List<Security> security = new ArrayList<Security>();
		it.forEach(e -> security.add(e));
		return security;
	}

	public String saveSecurity(Security security){
		return "Successfully saved Security Details: " + securityRepo.save(security);
	}
	
	public List<Security> searchSecurity(String name){
		return securityRepo.findByName(name);
	}
}
