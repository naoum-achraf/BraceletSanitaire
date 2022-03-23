package com.CiH.médicament;

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
public class InfosController {
	@Autowired
	private InfosRepo Repo;
	
	
	@GetMapping("/infos/{id}")
	public Infos négatives(@PathVariable Long id) {
		return Repo.getInfosPateint(id);
	}
	
	@GetMapping("/Myinfos/{id}")
	public List<Infos> nég(@PathVariable Long id) {
		return Repo.getMyInfos(id);
	}
	
	
	@GetMapping("/infosUp/{id}")
	public Infos négative2(@PathVariable Long id) {
		return Repo.getInfosUp(id);
	}
	
	@GetMapping("/Allinfos/{id}")
	public List<Infos> négative(@PathVariable Long id) {
		return Repo.getAllInfosPateint(id);
	}
	
	@PostMapping("/AddInfos")
	public ResponseEntity<?> registerUser(@Valid @RequestBody InfosRequeste Request) {
		InfosRepo repo = null;
		UserRepository repo1 = null;
		Optional<User> a = repo1.findById((long) 1);
		repo.save(new Infos(Request.Age,Request.Sex,Request.ChestPainType,Request.Cholesterol,Request.ExerciseAngina,Request.FastingBS,Request.oldpeak,Request.RestingECG,Request.ST_Slope,Request.Danger,a.get()));

		return ResponseEntity.ok(new MessageResponse("Utilisateur inscrit avec succès!"));
	}
	
	@PutMapping("/Infos/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody Infos u) {
		Infos i = Repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Infos not existe"));
		i.setAge(u.getAge());
		i.setSex(u.getSex());
		i.setChestPainType(u.getChestPainType());
		i.setCholesterol(u.getCholesterol());
		i.setExerciseAngina(u.getExerciseAngina());
		i.setFastingBS(u.getFastingBS());
		i.setOldpeak(u.getOldpeak());
		i.setRestingECG(u.getRestingECG());
		i.setST_Slope(u.getST_Slope());
		i.setDanger(u.getDanger());
		Infos updt = Repo.save(i);
		return ResponseEntity.ok(new MessageResponse("Infos updated avec succès!"));
	}

}
