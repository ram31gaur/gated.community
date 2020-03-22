package com.gated.repo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gated.model.Visitor;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VisitorRepoTest {

	@Autowired
	VisitorRepo repository;
	
	@Test
	public void test() {
		Visitor visitor = new Visitor();
		visitor.setApprovalFor("For");
		visitor.setApprovedBy("By");
		visitor.setName("name");
		visitor.setPurpose("purpose");
		visitor.setStatus("status");
        repository.save(visitor);
        Assert.assertNotNull(visitor.getId());
    }

}
