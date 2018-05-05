package com.medics.dao;

import java.util.List;

import com.medics.domain.PatientCommand;

public interface PatitentDao {

	public boolean savePatitentDetail(PatientCommand patitentValue);
	public List<PatientCommand> getAllPatitentDetail();
	public PatientCommand getPatitentDetailById(int HospitalId);
}
