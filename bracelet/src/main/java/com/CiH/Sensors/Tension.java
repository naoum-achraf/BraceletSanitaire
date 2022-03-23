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
public class Tension {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
		User user;
	  
	  int Tens1;
	  int Tens2;
	  int Tens3;
	  int Tens4;
	  int Tens5;
	  int Tens6;
	  int Tens7;
	  int Tens8;
	  int Tens9;
	  int Tens10;
	  int Tens11;
	  int Tens12;
	  int Tens13;
	  int Tens14;
	  int Tens15;
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
	public int getTens1() {
		return Tens1;
	}
	public void setTens1(int tens1) {
		Tens1 = tens1;
	}
	public int getTens2() {
		return Tens2;
	}
	public void setTens2(int tens2) {
		Tens2 = tens2;
	}
	public int getTens3() {
		return Tens3;
	}
	public void setTens3(int tens3) {
		Tens3 = tens3;
	}
	public int getTens4() {
		return Tens4;
	}
	public void setTens4(int tens4) {
		Tens4 = tens4;
	}
	public int getTens5() {
		return Tens5;
	}
	public void setTens5(int tens5) {
		Tens5 = tens5;
	}
	public int getTens6() {
		return Tens6;
	}
	public void setTens6(int tens6) {
		Tens6 = tens6;
	}
	public int getTens7() {
		return Tens7;
	}
	public void setTens7(int tens7) {
		Tens7 = tens7;
	}
	public int getTens8() {
		return Tens8;
	}
	public void setTens8(int tens8) {
		Tens8 = tens8;
	}
	public int getTens9() {
		return Tens9;
	}
	public void setTens9(int tens9) {
		Tens9 = tens9;
	}
	public int getTens10() {
		return Tens10;
	}
	public void setTens10(int tens10) {
		Tens10 = tens10;
	}
	public int getTens11() {
		return Tens11;
	}
	public void setTens11(int tens11) {
		Tens11 = tens11;
	}
	public int getTens12() {
		return Tens12;
	}
	public void setTens12(int tens12) {
		Tens12 = tens12;
	}
	public int getTens13() {
		return Tens13;
	}
	public void setTens13(int tens13) {
		Tens13 = tens13;
	}
	public int getTens14() {
		return Tens14;
	}
	public void setTens14(int tens14) {
		Tens14 = tens14;
	}
	public int getTens15() {
		return Tens15;
	}
	public void setTens15(int tens15) {
		Tens15 = tens15;
	}
	
	public Tension(long id, User user, int tens1, int tens2, int tens3, int tens4, int tens5, int tens6, int tens7,
			int tens8, int tens9, int tens10, int tens11, int tens12, int tens13, int tens14, int tens15) {
		super();
		this.id = id;
		this.user = user;
		Tens1 = tens1;
		Tens2 = tens2;
		Tens3 = tens3;
		Tens4 = tens4;
		Tens5 = tens5;
		Tens6 = tens6;
		Tens7 = tens7;
		Tens8 = tens8;
		Tens9 = tens9;
		Tens10 = tens10;
		Tens11 = tens11;
		Tens12 = tens12;
		Tens13 = tens13;
		Tens14 = tens14;
		Tens15 = tens15;
	}
	public Tension() {
		super();
	}
	
	
	  
	
	
}