package com.gated.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gated.model.Ticket;
import com.gated.repo.TicketRepo;

@Service
public class TicketService {

	@Autowired private TicketRepo ticketRepo;
	
	public List<Ticket> findAll(){
		List<Ticket> it = ticketRepo.findAll();
		List<Ticket> ticket = new ArrayList<Ticket>();
		it.forEach(e -> ticket.add(e));
		return ticket;
	}

	public String raiseTicket(Ticket ticket){
		return "Successfully raised ticket : "+ ticketRepo.save(ticket);
	}
	
	public Optional<Ticket> searchTicket(Integer id){
		return ticketRepo.findById(id);
	}

	public List<Ticket> myTickets(String userName) {
		return ticketRepo.findByRaisedBy(userName);
	}
}
