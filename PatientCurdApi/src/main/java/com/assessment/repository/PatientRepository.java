package com.assessment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    <MyUser> Optional<MyUser> findByName(String name);
}
