package com.gated.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VISITOR")
public class Visitor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String approvalFor;
	private String purpose;
	private String approvedBy;
	private String status;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	
	public Visitor(){}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", approvalFor=" + approvalFor + ", purpose=" + purpose
				+ ", approvedBy=" + approvedBy + ", status=" + status + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + "]";
	}

	public Visitor(String name, String approvalFor, String purpose, String approvedBy, String status,
			LocalDateTime checkIn, LocalDateTime checkOut) {
		this.name = name;
		this.approvalFor = approvalFor;
		this.purpose = purpose;
		this.approvedBy = approvedBy;
		this.status = status;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApprovalFor() {
		return approvalFor;
	}

	public void setApprovalFor(String approvalFor) {
		this.approvalFor = approvalFor;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}

	

}
