package com.gated.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gated.model.Security;

public interface SecurityRepo extends JpaRepository<Security, Integer> {

	List<Security> findByName(String name);
}
