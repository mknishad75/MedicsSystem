package com.medics.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medics.domain.PatientCommand;
@Service
public interface PatitentService {

	public boolean addPatitentDetail(PatientCommand patitentDetail);
	public List<PatientCommand> getAllPatitentDetail();
	public PatientCommand getPatitentDetailById(int HospitalId);
}
