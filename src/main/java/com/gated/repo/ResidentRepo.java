package com.gated.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gated.model.Resident;

public interface ResidentRepo extends JpaRepository<Resident, Integer> {

	List<Resident> findByName(String name);
}
