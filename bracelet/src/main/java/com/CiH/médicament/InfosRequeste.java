package com.CiH.médicament;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.CiH.login.models.User;


public class InfosRequeste{

  
   int user_id;
  
   String Age;
   String Sex;
 
   String ChestPainType;

   String Cholesterol;

   String FastingBS;
  
   String RestingECG;
   String ExerciseAngina;
   String oldpeak;
  String ST_Slope;
  String Danger;


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

}
