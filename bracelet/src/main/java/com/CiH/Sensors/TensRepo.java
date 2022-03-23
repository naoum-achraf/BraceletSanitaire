package com.CiH.Sensors;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CiH.login.models.User;

public interface TensRepo extends CrudRepository<Tension, Long>{

	@Query(value="Select * from tension where user_id = ?1 ",nativeQuery = true)
	Tension getTensPateint(Long id);
	
}
