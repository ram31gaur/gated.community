package com.gated.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gated.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	List<Ticket> findByRaisedBy(String userName);

}
