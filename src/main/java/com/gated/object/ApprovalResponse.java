package com.gated.object;

public class ApprovalResponse {
	String status;
	String approvedBy;
	Integer id;
	
	public ApprovalResponse(){
		
	}
	
	public ApprovalResponse(String status, String approvedBy, Integer id) {
		this.status = status;
		this.approvedBy = approvedBy;
		this.id = id;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
