package com.gated.repo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gated.model.Resident;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ResidentRepoTest {

	@Autowired
	ResidentRepo repository;
     
    @Test
    public void testRepository() 
    {
    	Resident resident = new Resident();
    	resident.setAddress("XYZ");
    	resident.setEmail("email");
    	resident.setName("name");
    	resident.setPhone("phone");
    	resident.setSsn("ssn");
        repository.save(resident);
        Assert.assertNotNull(resident.getId());
    }

}
