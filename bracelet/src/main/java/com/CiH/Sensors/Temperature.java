package com.CiH.Sensors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.CiH.login.models.User;


@Entity
public class Temperature {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
		User user;
	  
	  int Temp1;
	  int Temp2;
	  int Temp3;
	  int Temp4;
	  int Temp5;
	  int Temp6;
	  int Temp7;
	  int Temp8;
	  int Temp9;
	  int Temp10;
	  int Temp11;
	  int Temp12;
	  int Temp13;
	  int Temp14;
	  int Temp15;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getTemp1() {
		return Temp1;
	}
	public void setTemp1(int temp1) {
		Temp1 = temp1;
	}
	public int getTemp2() {
		return Temp2;
	}
	public void setTemp2(int temp2) {
		Temp2 = temp2;
	}
	public int getTemp3() {
		return Temp3;
	}
	public void setTemp3(int temp3) {
		Temp3 = temp3;
	}
	public int getTemp4() {
		return Temp4;
	}
	public void setTemp4(int temp4) {
		Temp4 = temp4;
	}
	public int getTemp5() {
		return Temp5;
	}
	public void setTemp5(int temp5) {
		Temp5 = temp5;
	}
	public int getTemp6() {
		return Temp6;
	}
	public void setTemp6(int temp6) {
		Temp6 = temp6;
	}
	public int getTemp7() {
		return Temp7;
	}
	public void setTemp7(int temp7) {
		Temp7 = temp7;
	}
	public int getTemp8() {
		return Temp8;
	}
	public void setTemp8(int temp8) {
		Temp8 = temp8;
	}
	public int getTemp9() {
		return Temp9;
	}
	public void setTemp9(int temp9) {
		Temp9 = temp9;
	}
	public int getTemp10() {
		return Temp10;
	}
	public void setTemp10(int temp10) {
		Temp10 = temp10;
	}
	public int getTemp11() {
		return Temp11;
	}
	public void setTemp11(int temp11) {
		Temp11 = temp11;
	}
	public int getTemp12() {
		return Temp12;
	}
	public void setTemp12(int temp12) {
		Temp12 = temp12;
	}
	public int getTemp13() {
		return Temp13;
	}
	public void setTemp13(int temp13) {
		Temp13 = temp13;
	}
	public int getTemp14() {
		return Temp14;
	}
	public void setTemp14(int temp14) {
		Temp14 = temp14;
	}
	public int getTemp15() {
		return Temp15;
	}
	public void setTemp15(int temp15) {
		Temp15 = temp15;
	}
	public Temperature(long id, User user, int temp1, int temp2, int temp3, int temp4, int temp5, int temp6, int temp7,
			int temp8, int temp9, int temp10, int temp11, int temp12, int temp13, int temp14, int temp15) {
		super();
		this.id = id;
		this.user = user;
		Temp1 = temp1;
		Temp2 = temp2;
		Temp3 = temp3;
		Temp4 = temp4;
		Temp5 = temp5;
		Temp6 = temp6;
		Temp7 = temp7;
		Temp8 = temp8;
		Temp9 = temp9;
		Temp10 = temp10;
		Temp11 = temp11;
		Temp12 = temp12;
		Temp13 = temp13;
		Temp14 = temp14;
		Temp15 = temp15;
	}
	public Temperature() {
		super();
	}
	  
	
	
}
