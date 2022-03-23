package com.CiH.médicament;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;

import com.CiH.login.models.User;
import com.CiH.login.models.User_role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
public class Infos{
  @Override
	public String toString() {
		return "Infos [id=" + id + ", user=" + user + ", ChestPainType=" + ChestPainType + ", Cholesterol="
				+ Cholesterol + ", FastingBS=" + FastingBS + ", RestingECG=" + RestingECG + ", ExerciseAngina="
				+ ExerciseAngina + ", oldpeak=" + oldpeak + ", ST_Slope=" + ST_Slope + ", Danger=" + Danger + "]";
	}



@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
  
  	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
	User user;
  
   String Age;
   
   String Sex;
 
   public Infos(long id, User user, String age, String sex, String chestPainType, String cholesterol, String fastingBS,
		String restingECG, String exerciseAngina, String oldpeak, String sT_Slope, String danger) {
	super();
	this.id = id;
	this.user = user;
	Age = age;
	Sex = sex;
	ChestPainType = chestPainType;
	Cholesterol = cholesterol;
	FastingBS = fastingBS;
	RestingECG = restingECG;
	ExerciseAngina = exerciseAngina;
	this.oldpeak = oldpeak;
	ST_Slope = sT_Slope;
	Danger = danger;
}



String ChestPainType;

   String Cholesterol;

   String FastingBS;
  
   String RestingECG;
   String ExerciseAngina;
   String oldpeak;
  String ST_Slope;
 
  String Danger;



  public Infos(String age,String sex,String chestPainType2, String cholesterol2, String exerciseAngina2, String fastingBS2, String oldpeak2, String restingECG2, String sT_Slope2, String danger2, User user2) {
	  super();
		this.user = user2;
		Age=age;
		Sex=sex;
		ChestPainType = chestPainType2;
		Cholesterol = cholesterol2;
		FastingBS = fastingBS2;
		RestingECG = restingECG2;
		ExerciseAngina = exerciseAngina2;
		this.oldpeak = oldpeak2;
		ST_Slope = sT_Slope2;
		Danger = danger2;
  }



public String getAge() {
	return Age;
}



public void setAge(String age) {
	Age = age;
}



public String getSex() {
	return Sex;
}



public void setSex(String sex) {
	Sex = sex;
}



public Infos() {
	super();
}



public long getId() {
	return id;
}



public Infos(User user, String chestPainType, String cholesterol, String fastingBS, String restingECG,
		String exerciseAngina, String oldpeak, String sT_Slope, String danger) {
	super();
	this.user = user;
	ChestPainType = chestPainType;
	Cholesterol = cholesterol;
	FastingBS = fastingBS;
	RestingECG = restingECG;
	ExerciseAngina = exerciseAngina;
	this.oldpeak = oldpeak;
	ST_Slope = sT_Slope;
	Danger = danger;
}



public User getUser() {
	return user;
}



public void setUser(User user) {
	this.user = user;
}



public void setId(long id) {
	this.id = id;
}


public String getChestPainType() {
	return ChestPainType;
}



public void setChestPainType(String chestPainType) {
	this.ChestPainType = chestPainType;
}



public String getCholesterol() {
	return Cholesterol;
}



public void setCholesterol(String cholesterol) {
	Cholesterol = cholesterol;
}



public String getFastingBS() {
	return FastingBS;
}



public void setFastingBS(String fastingBS) {
	FastingBS = fastingBS;
}



public String getRestingECG() {
	return RestingECG;
}



public void setRestingECG(String restingECG) {
	RestingECG = restingECG;
}



public String getExerciseAngina() {
	return ExerciseAngina;
}



public void setExerciseAngina(String exerciseAngina) {
	ExerciseAngina = exerciseAngina;
}



public String getOldpeak() {
	return oldpeak;
}



public void setOldpeak(String oldpeak) {
	this.oldpeak = oldpeak;
}



public String getST_Slope() {
	return ST_Slope;
}



public void setST_Slope(String sT_Slope) {
	ST_Slope = sT_Slope;
}



public String getDanger() {
	return Danger;
}



public void setDanger(String danger) {
	Danger = danger;
}



public Infos(long id,User u, String chestPainType, String cholesterol, String fastingBS, String restingECG,
		String exerciseAngina, String oldpeak, String sT_Slope, String danger) {
	super();
	this.id = id;
	this.user=u;
	this.ChestPainType = chestPainType;
	this.Cholesterol = cholesterol;
	this.FastingBS = fastingBS;
	this.RestingECG = restingECG;
	this.ExerciseAngina = exerciseAngina;
	this.oldpeak = oldpeak;
	this.ST_Slope = sT_Slope;
	this.Danger = danger;
}
  
}
