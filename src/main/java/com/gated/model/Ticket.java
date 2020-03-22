package com.gated.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="TiCKET")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String raisedBy;
	private String raisedFor;
	private String status = "Submited";
	private String issue;
	@CreationTimestamp
	private LocalDateTime submited;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	public Ticket(){
		
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", raisedBy=" + raisedBy + ", raisedFor=" + raisedFor + ", status=" + status
				+ ", issue=" + issue + ", submited=" + submited + ", lastUpdated=" + lastUpdated + "]";
	}

	public Ticket(String raisedBy, String raisedFor, String status, String issue) {
		this.raisedBy = raisedBy;
		this.raisedFor = raisedFor;
		this.status = status;
		this.issue = issue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}

	public String getRaisedFor() {
		return raisedFor;
	}

	public void setRaisedFor(String raisedFor) {
		this.raisedFor = raisedFor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public LocalDateTime getSubmited() {
		return submited;
	}

	public void setSubmited(LocalDateTime submited) {
		this.submited = submited;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}
