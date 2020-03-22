package com.gated.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gated.model.Visitor;
import com.gated.object.ApprovalResponse;
import com.gated.repo.VisitorRepo;

@Service
public class VisitorService {

	@Autowired private VisitorRepo visitorRepo;
	
	public List<Visitor> findAll(){
		List<Visitor> it = visitorRepo.findAll();
		List<Visitor> visitors = new ArrayList<Visitor>();
		it.forEach(e -> visitors.add(e));
		return visitors;
	}
	
	public String saveVisitor(Visitor visitor){
		return "Successfully saved Visitor Details:" + visitorRepo.save(visitor);
	}
	
	public List<Visitor> searchVisitor(String name){
		return visitorRepo.findByName(name);
	}

	public String approveVisitor(ApprovalResponse status) {
		
		Optional<Visitor> visitorToBeAproved = visitorRepo.findById(status.getId());
		
		if(!visitorToBeAproved.isPresent())
			return "Request can not approved, due to Invalid Visitor";
		
		if(!status.getApprovedBy().equals(visitorToBeAproved.get().getApprovalFor()))
			return "Request can not approved, due to Invalid Approver";
		
		return (0 != visitorRepo.setApprovalFor(status.getStatus(), status.getApprovedBy(), status.getId())?"Approved":"Not Approved");

	}
	
	public Integer checkIn(Integer id){
		return visitorRepo.checkIn(id, LocalDateTime.now());
	}
	
	public Integer checkOut(Integer id){
		return visitorRepo.checkOut(id, LocalDateTime.now());
	}

	public List<Visitor> myApprovals(String userName) {
		return visitorRepo.findByApprovedBy(userName);
	}
	
}
