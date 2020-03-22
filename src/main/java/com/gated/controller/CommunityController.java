package com.gated.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gated.model.Resident;
import com.gated.model.Security;
import com.gated.model.Ticket;
import com.gated.model.Visitor;
import com.gated.object.ApprovalResponse;
import com.gated.service.ResidentService;
import com.gated.service.SecurityService;
import com.gated.service.TicketService;
import com.gated.service.VisitorService;

@RestController
public class CommunityController {

	@Autowired private ResidentService residentService;
	@Autowired private VisitorService visitorService;
	@Autowired private SecurityService securityService;
	@Autowired private TicketService ticketService;

	Logger log = LoggerFactory.getLogger(CommunityController.class);
	
	@GetMapping("/home")
	public String home() {
		return "Welcome";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/listAllTicket")
	public String listAllTicket(){
	return ticketService.findAll().toString();
	}

	@PostMapping("/raiseTicket")
	public String raiseTicket(@RequestBody Ticket issue){
		return ticketService.raiseTicket(issue).toString();
	}

	@PostMapping("/myTickets")
	public String myTickets(@RequestBody String userName){
		return ticketService.myTickets(userName).toString();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/myApprovals")
	public String myApprovals(@RequestBody String userName){
		return visitorService.myApprovals(userName).toString();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@PostMapping("/approveVisitors")
	public String approveVisitors(@RequestBody ApprovalResponse status){
	return visitorService.approveVisitor(status);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/checkInVisitor")
	public Integer checkInVisitor(@RequestBody String visitorId){
		return visitorService.checkIn(Integer.parseInt(visitorId));
	}
	
	@PostMapping("/checkOutVisitor")
	public Integer checkOutVisitor(@RequestBody String visitorId){
		return visitorService.checkOut(Integer.parseInt(visitorId));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@GetMapping("/listAllResidents")
	public String listAllResidents(){
	return residentService.findAll().toString();
	}
	
	@GetMapping("/listAllVisitors")
	public String listAllVisitors(){
	return visitorService.findAll().toString();
	}
	
	@GetMapping("/listAllSecurity")
	public String listAllSecurity(){
	return securityService.findAll().toString();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/saveResidents")
	public String saveResidents(@RequestBody Resident resident){
		return residentService.saveResident(resident);
	}
	
	@PostMapping("/saveVisitors")
	public String saveVisitors(@RequestBody Visitor visitor){
		return visitorService.saveVisitor(visitor);
	}
	
	@PostMapping("/saveSecurity")
	public String saveSecurity(@RequestBody Security security){
		return securityService.saveSecurity(security);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/searchResidents")
	public String searchResidents(@RequestBody String name){
		return residentService.searchResident(name).toString();
	}
	
	@PostMapping("/searchVisitors")
	public String searchVisitors(@RequestBody String name){
		return visitorService.searchVisitor(name).toString();
	}
	
	@PostMapping("/searchSecurity")
	public String searchSecurity(@RequestBody String name){
		return securityService.searchSecurity(name).toString();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
