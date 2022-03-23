package com.CiH.Sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CiH.login.models.ERole;
import com.CiH.login.models.Role;
import com.CiH.login.models.User;
import com.CiH.login.models.User_role;
import com.CiH.login.payload.request.SignupRequest;
import com.CiH.login.payload.response.MessageResponse;
import com.CiH.login.repository.UserRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TempController {
	@Autowired
	private TempRepo Repo;
	
	
	@GetMapping("/Temperature/{id}")
	public Temperature négatives(@PathVariable Long id) {
		return Repo.getTempPateint(id);
	}
	

	

	

	


}
