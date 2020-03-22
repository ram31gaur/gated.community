package com.gated.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gated.model.Ticket;
import com.gated.repo.TicketRepo;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {

	@InjectMocks
	TicketService service;
     
    @Mock
    TicketRepo dao;
    
	@Test
	public void findAll() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket resOne = new Ticket("John", "XYZ", "Submited", "security");
	    Ticket resTwo = new Ticket("Alex", "XYZ", "Submited", "security");
	    Ticket resThree = new Ticket("Steve", "XYZ", "Submited", "security");
	    list.add(resOne);
	    list.add(resTwo);
	    list.add(resThree);
	    when(dao.findAll()).thenReturn(list); 

	    List<Ticket> empList = service.findAll();
	    assertEquals(3, empList.size());
	}
	
	@Test
	public void raiseTicket() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket resOne = new Ticket("John", "XYZ", "Submited", "security");
	    list.add(resOne);
	    when(dao.save(resOne)).thenReturn(resOne);
	    
	    String empSaved = service.raiseTicket(resOne);
	    assertEquals("Successfully raised ticket : Ticket [id=null, raisedBy=John, raisedFor=XYZ, status=Submited, issue=security, submited=null, lastUpdated=null]", empSaved);
	}
	
	@Test
	public void myTicket() {
		String name = "John";
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket resOne = new Ticket("John", "XYZ", "Submited", "security");
	    list.add(resOne);
		when(dao.findByRaisedBy(name)).thenReturn(list);
		List<Ticket> i = service.myTickets(name);
		assertEquals(list, i);
	}

}
