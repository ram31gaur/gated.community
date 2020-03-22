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

import com.gated.model.Security;
import com.gated.repo.SecurityRepo;

@RunWith(MockitoJUnitRunner.class)
public class SecurityServiceTest {

	@InjectMocks
	SecurityService service;
     
    @Mock
    SecurityRepo dao;
    
	@Test
	public void findAll() {
		List<Security> list = new ArrayList<Security>();
		Security resOne = new Security("John", "XYZ", "123", "howtodoinjava@gmail.com", "123", "security");
	    Security resTwo = new Security("Alex", "XYZ", "123", "alexk@yahoo.com", "123", "security");
	    Security resThree = new Security("Steve", "XYZ", "123", "swaugh@gmail.com", "123", "security");
	    list.add(resOne);
	    list.add(resTwo);
	    list.add(resThree);
	    when(dao.findAll()).thenReturn(list); 

	    List<Security> empList = service.findAll();
	    assertEquals(3, empList.size());
	}
	
	@Test
	public void saveSecurity() {
		List<Security> list = new ArrayList<Security>();
		Security resOne = new Security("John", "XYZ", "123", "howtodoinjava@gmail.com", "123", "security");
	    list.add(resOne);
	    when(dao.save(resOne)).thenReturn(resOne);
	    
	    String empSaved = service.saveSecurity(resOne);
	    assertEquals("Successfully saved Security Details: Security [id=null, name=John, address=XYZ, phone=123, email=howtodoinjava@gmail.com, ssn=123, occupation=security, createdAt=null, updatedAt=null]", empSaved);
	}
	
	@Test
	public void searchSecurity() {
		String name = "John";
		List<Security> list = new ArrayList<Security>();
		Security resOne = new Security("John", "XYZ", "123", "howtodoinjava@gmail.com", "123", "security");
	    list.add(resOne);
		when(dao.findByName(name)).thenReturn(list);
		List<Security> list2 = service.searchSecurity(name);
		assertEquals(list, list2);
	}
}
