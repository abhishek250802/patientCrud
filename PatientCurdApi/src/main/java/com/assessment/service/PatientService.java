package com.assessment.service;

import java.util.List;

import com.assessment.model.PatientModel;

public interface PatientService {
	
	List<PatientModel> getAllPatients();

	PatientModel getPatientsById(int id);

	PatientModel createPatient(PatientModel patientModel);

	PatientModel updatePatient(int id, PatientModel patientDetails);

	int deletePatientsById(int id);

	PatientModel getPatientsById();

	

}
