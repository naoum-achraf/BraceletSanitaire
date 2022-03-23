package com.CiH.Messagerie;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CiH.login.models.User;

public interface MessagerieRepo extends CrudRepository<Messagerie, Long>{

	@Query(value="Select * from infos where user_id = ?1 ",nativeQuery = true)
	List<Messagerie> getInfosPateint(Long id);
	
	@Query(value="Select * from Messagerie where receiver_id = ?1 ",nativeQuery = true)
	List<Messagerie> getMessageM(Long id);
}
