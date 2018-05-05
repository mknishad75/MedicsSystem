package com.medics.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medics.domain.PatientCommand;


@Repository
@Transactional
public class PatitentDaoImp implements PatitentDao {

	@Autowired
	HibernateTemplate hTemp;
	
	@Override
	public boolean savePatitentDetail(PatientCommand patitentValue) {
		PatientCommand setPatittentValue=new PatientCommand();
		setPatittentValue.setHospitalId(patitentValue.getHospitalId());
		setPatittentValue.setPatientId(patitentValue.getPatientId());
		setPatittentValue.setPatitentName(patitentValue.getPatitentName());
		setPatittentValue.setPatitentAddress(patitentValue.getPatitentAddress());
		hTemp.save(setPatittentValue);
		
		return true;
	}

	@Override
	public List<PatientCommand> getAllPatitentDetail() {
		List<PatientCommand> list=new ArrayList<PatientCommand>();  
		List<PatientCommand> clist=(List<PatientCommand>) hTemp.find("from PatientCommand patitent");
		
		
		if(clist.size()>0)
		{
			for(PatientCommand p:clist)
			{
				PatientCommand getAllPatitentValue=new PatientCommand();
				getAllPatitentValue.setHospitalId(p.getHospitalId());
				getAllPatitentValue.setPatientId(p.getPatientId());
				getAllPatitentValue.setPatitentName(p.getPatitentName());
				getAllPatitentValue.setPatitentAddress(p.getPatitentAddress());
				
				list.add(getAllPatitentValue); 
			}
			
		}
		    
		
		return list;
	}

	@Override
	public PatientCommand getPatitentDetailById(int HospitalId) {
		
		PatientCommand patittentValueInstance=hTemp.load(PatientCommand.class, HospitalId);
		PatientCommand patitetSetValueInstance=new PatientCommand();
		patitetSetValueInstance.setHospitalId(patittentValueInstance.getHospitalId());
		patitetSetValueInstance.setPatientId(patittentValueInstance.getPatientId());
		patitetSetValueInstance.setPatitentName(patittentValueInstance.getPatitentName());
		patitetSetValueInstance.setPatitentAddress(patittentValueInstance.getPatitentAddress());
		
		return patitetSetValueInstance;
	}

}
