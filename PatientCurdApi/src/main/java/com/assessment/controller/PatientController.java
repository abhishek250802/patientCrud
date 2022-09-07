package com.assessment.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.model.PatientModel;
import com.assessment.service.PatientService;



@RestController
@RequestMapping("/patient")
public class PatientController {
	
	private final PatientService pmService;
	
	PatientController(PatientService pmService) {
          this.pmService = pmService;
	}
	
@GetMapping
public ResponseEntity<List<PatientModel>> getAll(){
	return ResponseEntity.ok().body(pmService.getAllPatients());
}

@GetMapping("/{id}")
public ResponseEntity<PatientModel> getPatient(@PathVariable("id")int id){
	return ResponseEntity.ok().body(pmService.getPatientsById(id));
}

@PostMapping
public ResponseEntity<Boolean> savePatient(@Valid @RequestBody PatientModel patient){
	return ResponseEntity.ok().body(pmService.createPatient(patient));
}

@PutMapping("/{id}")
public ResponseEntity<Boolean> updatePatient(@Validated @PathVariable("id") int id,@RequestBody PatientModel patientDetails){
	return ResponseEntity.ok().body(pmService.updatePatient(patientDetails));
}

@DeleteMapping("/{id}")
public ResponseEntity<Boolean> deletePatient(@PathVariable("id") int id){
	return ResponseEntity.ok().body(pmService.deletePatientsById(id));
} 

}


