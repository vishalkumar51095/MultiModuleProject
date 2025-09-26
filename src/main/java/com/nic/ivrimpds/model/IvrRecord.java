package com.nic.ivrimpds.model;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ivr_records")
public class IvrRecord {
	
	@Id
    private int id;
    private String callerId;
    private Timestamp callTime;
    private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCallerId() {
		return callerId;
	}
	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}
	public Timestamp getCallTime() {
		return callTime;
	}
	public void setCallTime(Timestamp callTime) {
		this.callTime = callTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    

}