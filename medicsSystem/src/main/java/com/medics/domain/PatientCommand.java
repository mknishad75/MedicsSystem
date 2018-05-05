package com.medics.domain;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uploadfile")
public class PatientCommand {
	
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int hospitalId;	

@Column
private int patientId;
@Column
private String patitentName;
@Column
private String patitentAddress;



public PatientCommand() {
}







public PatientCommand(int hospitalId, int patientId, String patitentName, String patitentAddress) {
	super();
	this.hospitalId = hospitalId;
	this.patientId = patientId;
	this.patitentName = patitentName;
	this.patitentAddress = patitentAddress;
}







public int getHospitalId() {
	return hospitalId;
}







public void setHospitalId(int hospitalId) {
	this.hospitalId = hospitalId;
}







public int getPatientId() {
	return patientId;
}



public void setPatientId(int patientId) {
	this.patientId = patientId;
}



public String getPatitentName() {
	return patitentName;
}



public void setPatitentName(String patitentName) {
	this.patitentName = patitentName;
}



public String getPatitentAddress() {
	return patitentAddress;
}



public void setPatitentAddress(String patitentAddress) {
	this.patitentAddress = patitentAddress;
}


	
}
