package com.gated.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gated.model.Visitor;
import com.gated.repo.VisitorRepo;

@RunWith(MockitoJUnitRunner.Silent.class)
public class VisitorServiceTest {

	@InjectMocks
	VisitorService service;
     
    @Mock
    VisitorRepo dao;
    
	@Test
	public void findAll() {
		List<Visitor> list = new ArrayList<Visitor>();
		Visitor resOne = new Visitor("John", "XYZ", "purpose", "resident", "submitted", null, null);
	    Visitor resTwo = new Visitor("Alex", "XYZ", "purpose", "resident", "submitted", null, null);
	    Visitor resThree = new Visitor("Steve", "XYZ", "purpose", "resident", "submitted", null, null);
	    list.add(resOne);
	    list.add(resTwo);
	    list.add(resThree);
	    when(dao.findAll()).thenReturn(list); 

	    List<Visitor> empList = service.findAll();
	    assertEquals(3, empList.size());
	}
	
	@Test
	public void saveVisitor() {
		List<Visitor> list = new ArrayList<Visitor>();
		Visitor resOne = new Visitor("John", "XYZ", "purpose", "resident", "submitted", null, null);
	    list.add(resOne);
	    when(dao.save(resOne)).thenReturn(resOne);
	    
	    String empSaved = service.saveVisitor(resOne);
	    assertEquals("Successfully saved Visitor Details:Visitor [id=null, name=John, approvalFor=XYZ, purpose=purpose, approvedBy=resident, status=submitted, checkIn=null, checkOut=null]", empSaved);
	}

	
	@Test
	public void myApprovals() {
		String name = "John";
		List<Visitor> list = new ArrayList<Visitor>();
		Visitor resOne = new Visitor("John", "XYZ", "purpose", "resident", "submitted", null, null);
		list.add(resOne);
		when(dao.findByApprovedBy(name)).thenReturn(list);
		List<Visitor> i = service.myApprovals(name);
		assertEquals(list, i);
	}
	
	@Test
	public void searchVisitor() {
		String name = "John";
		List<Visitor> list = new ArrayList<Visitor>();
		Visitor resOne = new Visitor("John", "XYZ", "purpose", "resident", "submitted", null, null);
		list.add(resOne);
		when(dao.findByApprovedBy(name)).thenReturn(list);
		List<Visitor> i = service.searchVisitor(name);
		assertEquals(new LinkedList<>(), i);
	}
	
}
