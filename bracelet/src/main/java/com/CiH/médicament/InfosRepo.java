package com.CiH.médicament;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CiH.login.models.User;

public interface InfosRepo extends CrudRepository<Infos, Long>{

	@Query(value="Select * from infos where user_id = ?1 ",nativeQuery = true)
	Infos getInfosPateint(Long id);
	
	@Query(value="Select * from infos where id = ?1 ",nativeQuery = true)
	Infos getInfosUp(Long id);
	
	@Query(value="Select * from infos where user_id = ?1 ",nativeQuery = true)
	List<Infos> getAllInfosPateint(Long id);

	
	@Query(value="Select * from infos where user_id = ?1 ",nativeQuery = true)
	List<Infos> getMyInfos(Long id);
}
