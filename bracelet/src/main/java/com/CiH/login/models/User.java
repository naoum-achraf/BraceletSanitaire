package com.CiH.login.models;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.CiH.Sensors.Frequence;
import com.CiH.Sensors.Temperature;
import com.CiH.Sensors.Tension;
import com.CiH.médicament.Infos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity

public class User{
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	public Set<User_role> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<User_role> registrations) {
		this.registrations = registrations;
	}


	String Hopitale;
	
	public String getHopitale() {
		return Hopitale;
	}

	public void setHopitale(String hopitale) {
		Hopitale = hopitale;
	}


	@NotBlank
	@Size(max = 50)
	private String age;

	@NotBlank
	@Size(max = 120)
	private String password;

	
	public User() {
	}

	public User(String username, String email,String age, String password) {
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	Set<User_role> registrations= new HashSet<>();
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
	@JsonIgnore
	Infos infos;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
	@JsonIgnore
	Temperature Temp;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
	@JsonIgnore
	Tension Tens;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
	@JsonIgnore
	Frequence Freq;
	

	public User(String username, String email,String age,String password,Infos inf, User_role... registrations) {
		super();
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.infos=inf;
		for(User_role registre : registrations) registre.setU(this);
		this.registrations = Stream.of(registrations).collect(Collectors.toSet());
	}
	
	public User(String username, String email,String age,String password, User_role... registrations) {
		super();
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		for(User_role registre : registrations) registre.setU(this);
		this.registrations = Stream.of(registrations).collect(Collectors.toSet());
	}
	
	public Infos getInfos() {
		return infos;
	}

	public void setInfos(Infos infos) {
		this.infos = infos;
	}

	public User(String username, String email,String age,String hopitale,String password,Infos inf, User_role... registrations) {
		super();
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.Hopitale=hopitale;
		this.infos=inf;
		for(User_role registre : registrations) registre.setU(this);
		this.registrations = Stream.of(registrations).collect(Collectors.toSet());
	}
	
	public User(String username, String email,String age,String hopitale,String password, User_role... registrations) {
		super();
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.Hopitale=hopitale;
		for(User_role registre : registrations) registre.setU(this);
		this.registrations = Stream.of(registrations).collect(Collectors.toSet());
	}
	
	
	
}
