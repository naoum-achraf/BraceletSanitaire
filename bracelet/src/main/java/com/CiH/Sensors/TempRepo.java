package com.CiH.Sensors;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CiH.login.models.User;

public interface TempRepo extends CrudRepository<Temperature, Long>{

	@Query(value="Select * from temperature where user_id = ?1 ",nativeQuery = true)
	Temperature getTempPateint(Long id);
	
}
