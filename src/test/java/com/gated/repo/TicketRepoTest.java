package com.gated.repo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gated.model.Ticket;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketRepoTest {

	@Autowired
	TicketRepo repository;
	
	@Test
	public void test() {
		Ticket ticket = new Ticket();
		ticket.setIssue("XYZ");
		ticket.setRaisedBy("raisedBy");
		ticket.setRaisedFor("raisedFor");
		ticket.setStatus("status");
        repository.save(ticket);
        Assert.assertNotNull(ticket.getId());
    }

}
