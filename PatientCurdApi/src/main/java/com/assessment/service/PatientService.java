package com.assessment.service;

import java.util.List;

import com.assessment.model.PatientModel;

public interface PatientService {
	
	List<PatientModel> getAllPatients();

	PatientModel getPatientsById(int id);

	boolean createPatient(PatientModel patientModel);


	boolean deletePatientsById(int id);

	boolean updatePatient(PatientModel patientDetails);



}
