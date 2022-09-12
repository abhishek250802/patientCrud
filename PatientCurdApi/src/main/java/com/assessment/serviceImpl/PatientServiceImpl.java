package com.assessment.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assessment.entity.Patient;
import com.assessment.exception.MareezAlreadyExist;
import com.assessment.exception.MareezNotExist;
import com.assessment.model.PatientModel;
import com.assessment.repository.PatientRepository;
import com.assessment.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService {


	private final PatientRepository patientRepository;
	
	PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	@Override
	public List<PatientModel> getAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		List<PatientModel> patientsModel = new ArrayList<>();
		
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
		Optional<Patient> p = patientRepository.findById(id);
		if (!p.isPresent())
		    throw new MareezNotExist("Mareez doesn't exist with id :" +id);
	   
		Patient patient = p.get();    
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
	public boolean createPatient( PatientModel patientModel) {
		Patient p = patientRepository.findById(patientModel.getId()).get();
		if(Objects.nonNull(p)) {
			throw new MareezAlreadyExist("Mareez Already Exist with id : "+p.getId());
				}
		Patient patient = new Patient();
		patient.setName(patientModel.getName());
		patient.setPhone(patientModel.getPhone());
	        patient.setDisease(patientModel.getDisease());
	        patient.setBedNo(patientModel.getBedNo());
	        patient.setAddress(patientModel.getAddress());
	        try {
	    patientRepository.save(patient);
		return true;
	        } catch (Exception ex)  {
	            return false;
	        }
	}
	
	@Override
	public boolean updatePatient(PatientModel patientDetails) {
	    Optional<Patient> updatePatient = patientRepository.findById(patientDetails.getId());
		Patient update= null;
	if
	(updatePatient.isPresent()) {
		update = updatePatient.get();
		update.setName(patientDetails.getName());
		update.setPhone(patientDetails.getPhone());
		update.setDisease(patientDetails.getDisease());
		update.setBedNo(patientDetails.getBedNo());
		update.setAddress(patientDetails.getAddress());
		patientRepository.save(update);
		return true;
	}
	        return false;
	}
	
	@Override
	public boolean deletePatientsById(int id) {
	    if (patientRepository.findById(id).isPresent()) {
		patientRepository.deleteById(id);
		return true;
	    }
	   throw new MareezNotExist("Delete nahi ho payega q ki koi mareez nhi hai is id s : " +id);
	}
}

	
	
	