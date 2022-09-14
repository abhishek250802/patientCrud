package com.assessment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assessment.entity.MyRoles;
import com.assessment.entity.MyUser;
import com.assessment.model.MyUserModel;
import com.assessment.repository.UserRepository;
import com.assessment.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	this.userRepository = userRepository;
	this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean creatingUser(MyUserModel userModel) {
	MyUser user = new MyUser();
	user.setId(userModel.getId());
	user.setUserName(userModel.getUserName());
	user.setPassword(passwordEncoder.encode(userModel.getPassword()));
	List<MyRoles> role = new ArrayList<>();
	userModel.getRole().stream().forEach(rm -> {
	    MyRoles myRole = new MyRoles();
	    myRole.setRole(rm.getRole());
	    myRole.setRoleId(rm.getRoleId());
	    role.add(myRole);
	});
	try {
	    userRepository.save(user);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

}
