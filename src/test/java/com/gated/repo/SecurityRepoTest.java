package com.gated.repo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gated.model.Security;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SecurityRepoTest {

	@Autowired
	SecurityRepo repository;
	
	@Test
	public void test() {
		Security security = new Security();
		security.setAddress("XYZ");
		security.setEmail("email");
		security.setName("name");
		security.setPhone("phone");
		security.setSsn("ssn");
		security.setOccupation("occupation");
        repository.save(security);
        Assert.assertNotNull(security.getId());
    }

}
