package com.gated.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gated.model.Visitor;

public interface VisitorRepo extends JpaRepository<Visitor, Integer> {

	Optional<Visitor> findById(Integer id);
	List<Visitor> findByName(String name);
	List<Visitor> findByApprovedBy(String userName);

	@Transactional(readOnly = false, rollbackFor = {Exception.class})
	@Modifying
	@Query("update Visitor set status = ?1, approvedBy = ?2 where id = ?3")
	int setApprovalFor(String status, String approvedBy, Integer id);
	
	@Transactional(readOnly = false, rollbackFor = {Exception.class})
	@Modifying
	@Query("update Visitor set checkIn = ?2 where id = ?1")
	int checkIn(Integer visitorId, LocalDateTime checkOutTime);
	
	@Transactional(readOnly = false, rollbackFor = {Exception.class})
	@Modifying
	@Query("update Visitor set checkOut = ?2 where id = ?1")
	int checkOut(Integer visitorId, LocalDateTime checkOutTime);
	
}
