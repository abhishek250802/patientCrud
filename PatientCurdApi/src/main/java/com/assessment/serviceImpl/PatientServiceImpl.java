package com.assessment.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.exception.MareezAlreadyExist;
import com.assessment.model.Patient;
import com.assessment.model.PatientModel;
import com.assessment.repository.PatientRepository;
import com.assessment.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository1;

	private final PatientRepository patientRepository;
	
	PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = null;
		this.patientRepository1 = patientRepository;
	}
	@Override
	public List<PatientModel> getAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		patientRepository1.findAll().forEach((patient) -> patients.add(patient));
		List<PatientModel> patientsModel = new ArrayList<PatientModel>();
		
		for (Patient p : patients) {
			PatientModel pm = new PatientModel();
			pm.setId(p.getId());
			pm.setName(p.getName());
			pm.setPhone(p.getPhone());
			pm.setDisease(p.getDisease());
			pm.setBedNo(p.getBedNo());
			pm.setAddress(p.getAddress());
			patientsModel.add(pm);
		
		}
		return patientsModel;
	}
	@Override
	public PatientModel getPatientsById(int id) {
		Patient patient = patientRepository1.findById(id).get();
		
		PatientModel pm = new PatientModel();
		pm.setId(patient.getId());
		pm.setName(patient.getName());
		pm.setPhone(patient.getPhone());
		pm.setDisease(patient.getDisease());
		pm.setBedNo(patient.getBedNo());
		pm.setAddress(patient.getAddress());
		return pm;
	}
	
	@Override
	public PatientModel createPatient(@Valid PatientModel patientModel) {
		Patient p = patientRepository1.findById(patientModel.getId()).get();
		if(Objects.nonNull(p)) {
			throw new MareezAlreadyExist("Mareez Already Exist with id : "+p.getId());
				}
		Patient patient = new Patient();
		patient.setName(patientModel.getName());
		patient.setPhone(patientModel.getPhone());
	    patient.setDisease(patientModel.getDisease());
	    patient.setBedNo(patientModel.getBedNo());
	    patient.setAddress(patientModel.getAddress());
	    patientRepository1.save(patient);
		return patientModel;
	}
	
	public PatientServiceImpl() {
	this.patientRepository = null;
	this.patientRepository1 = null;}
	


	@Override
	public PatientModel updatePatient(int id, PatientModel patientDetails) {
		Patient updatePatient = null;
	
		updatePatient = patientRepository1.findById(id).get();
		
		updatePatient.setName(patientDetails.getName());
		updatePatient.setPhone(patientDetails.getPhone());
		updatePatient.setDisease(patientDetails.getDisease());
		updatePatient.setBedNo(patientDetails.getBedNo());
		updatePatient.setAddress(patientDetails.getAddress());
		
		patientRepository1.save(updatePatient);
		return patientDetails;
	}
	@Override
	public int deletePatientsById(int id) {
		patientRepository1.deleteById(id);
		return id;
	}
	@Override
	public PatientModel getPatientsById() {
		// TODO Auto-generated method stub
		return null;
	}
	public PatientRepository getPatientRepository() {
		return patientRepository;
	}
	
	
}
	
	
	