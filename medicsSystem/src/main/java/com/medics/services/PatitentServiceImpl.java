package com.medics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medics.dao.PatitentDao;
import com.medics.domain.PatientCommand;

@Service
public class PatitentServiceImpl implements PatitentService {
     
	@Autowired
	PatitentDao patitentDao;
	
	@Override
	public boolean addPatitentDetail(PatientCommand patitentDetail) {
		
		return patitentDao.savePatitentDetail(patitentDetail);
	}

	@Override
	public List<PatientCommand> getAllPatitentDetail() {
		
		return patitentDao.getAllPatitentDetail();
	}

	@Override
	public PatientCommand getPatitentDetailById(int HospitalId) {
		
		return patitentDao.getPatitentDetailById(HospitalId);
	}

	
}
