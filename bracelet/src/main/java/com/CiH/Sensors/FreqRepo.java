package com.CiH.Sensors;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CiH.login.models.User;

public interface FreqRepo extends CrudRepository<Frequence, Long>{

	@Query(value="Select * from Freq where user_id = ?1 ",nativeQuery = true)
	Frequence getFreqPateint(Long id);
	
}
