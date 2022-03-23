package com.CiH.login.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CiH.login.controllers.*;
import com.CiH.login.models.*;
import com.CiH.login.payload.*;
import com.CiH.login.repository.*;
import com.CiH.login.security.*;
import com.CiH.login.security.jwt.*;
import com.CiH.login.security.services.*;
import com.CiH.médicament.Infos;
import com.CiH.médicament.InfosRepo;
import com.CiH.login.payload.request.*;
import com.CiH.login.payload.response.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	InfosRepo Repo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
											 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 userDetails.getAge(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Erreur: Username déja utilisé!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Erreur: Email déja utilisé!"));
		}

		// Create new user's account
		String strRoles = null;
		for (String value : signUpRequest.getRole()) {
			 		strRoles = value;
		}
		
		Role roles;
	
		if (strRoles == null) {
			Role patRole = roleRepository.findByName(ERole.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Erreur: pas de Role !!"));
			roles=patRole;
		} else {
				switch (strRoles) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Erreur: pas de Role !!"));
					roles=adminRole;

					break;
				case "medecin":
					Role agentRole = roleRepository.findByName(ERole.ROLE_MEDECIN)
							.orElseThrow(() -> new RuntimeException("Erreur: pas de role!!"));
					roles=agentRole;

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_PATIENT)
							.orElseThrow(() -> new RuntimeException("Erreur: pas de role !!"));
					roles=userRole;
					List<Infos> result = new ArrayList<>();
				    for (Infos str : Repo.findAll()) {
				        result.add(str);
				    }
				    
				    Infos i =new Infos();
				    User u = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 signUpRequest.getAge(),
							 encoder.encode(signUpRequest.getPassword()),
							 new User_role(roles, signUpRequest.getRespo(),true,(long) 0)
							 );
				    u.setInfos(i);
				    i.setUser(u);
				    
				
				    userRepository.save(u);
				    return ResponseEntity.ok(new MessageResponse("Utilisateur inscrit avec succès!"));
				    
				}
		}
		
		

		userRepository.save(new User(signUpRequest.getUsername(), 
				 signUpRequest.getEmail(),
				 signUpRequest.getAge(),
				 signUpRequest.getHopitale(),
				 encoder.encode(signUpRequest.getPassword()),
				 new User_role(roles, null)
				 ));

		return ResponseEntity.ok(new MessageResponse("Utilisateur inscrit avec succès!"));
	}
}
