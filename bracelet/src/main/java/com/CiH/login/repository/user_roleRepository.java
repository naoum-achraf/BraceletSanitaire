package com.CiH.login.repository;

import java.util.List;

import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CiH.login.models.User;
import com.CiH.login.models.User_role;

@Repository
public interface user_roleRepository extends JpaRepository<User_role, Long> {
	@Query(value="Select * from user_role where user_id = ?1",nativeQuery = true)
	public List<User_role> getRes(Long id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE user_role SET resultat = ?1 WHERE user_id = ?2",nativeQuery = true)
	public void updateResultat(Boolean res,Long idUser);
	
	
	@Query(value="Select * from user_role where resultat = false AND respo = ?1",nativeQuery = true)
	public List<User_role> getNégative(Long idRes);
	
	
	@Modifying
	@Transactional
	@Query(value="UPDATE user_role SET alert = alert + 1 WHERE user_id = ?1",nativeQuery = true)
	public void updateAlert(Long idUser);
	
	@Query(value="Select alert from user_role WHERE user_id = ?1",nativeQuery = true)
	public Long getAlert(Long idUser);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE user_role SET message = ?1 WHERE user_id = ?2",nativeQuery = true)
	public void SendMessage(String res,Long idUser);
	
	@Query(value="Select * from user_role where user_id = ?1",nativeQuery = true)
	public List<User_role> getMessage(Long id);
}
