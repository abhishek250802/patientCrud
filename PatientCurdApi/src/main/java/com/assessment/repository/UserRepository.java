package com.assessment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.entity.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>  {
    Optional<MyUser> findByuserName(String userName);




}
