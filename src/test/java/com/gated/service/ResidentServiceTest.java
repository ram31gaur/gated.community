package com.gated.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.gated.model.Resident;
import com.gated.repo.ResidentRepo;

@RunWith(MockitoJUnitRunner.class)
public class ResidentServiceTest {

	@InjectMocks
	ResidentService service;
     
    @Mock
    ResidentRepo dao;
    
	@Test
	public void findAll() {
		List<Resident> list = new ArrayList<Resident>();
		Resident resOne = new Resident("John", "XYZ", "123", "howtodoinjava@gmail.com", "123");
	    Resident resTwo = new Resident("Alex", "XYZ", "123", "alexk@yahoo.com", "123");
	    Resident resThree = new Resident("Steve", "XYZ", "123", "swaugh@gmail.com", "123");
	    list.add(resOne);
	    list.add(resTwo);
	    list.add(resThree);
	    when(dao.findAll()).thenReturn(list); 

	    List<Resident> empList = service.findAll();
	    assertEquals(3, empList.size());
	}
	
	@Test
	public void saveResident() {
		List<Resident> list = new ArrayList<Resident>();
		Resident resOne = new Resident("John", "XYZ", "123", "howtodoinjava@gmail.com", "123");
	    list.add(resOne);
	    when(dao.save(resOne)).thenReturn(resOne);
	    
	    String empSaved = service.saveResident(resOne);
	    assertEquals("Successfully saved Resident Details: Resident [id=null, name=John, address=XYZ, phone=123, email=howtodoinjava@gmail.com, ssn=123, createdAt=null, updatedAt=null]", empSaved);
	}
	
	@Test
	public void searchResident() {
		String name = "John";
		List<Resident> list = new ArrayList<Resident>();
		Resident resOne = new Resident("John", "XYZ", "123", "howtodoinjava@gmail.com", "123");
	    list.add(resOne);
		when(dao.findByName(name)).thenReturn(list);
		List<Resident> list2 = service.searchResident(name);
		assertEquals(list, list2);
	}
}
