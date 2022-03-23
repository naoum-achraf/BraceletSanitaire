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
public class Frequence {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
		User user;
	  
	  int Freq1;
	  int Freq2;
	  int Freq3;
	  int Freq4;
	  int Freq5;
	  int Freq6;
	  int Freq7;
	  int Freq8;
	  int Freq9;
	  int Freq10;
	  int Freq11;
	  int Freq12;
	  int Freq13;
	  int Freq14;
	  int Freq15;
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
	public int getFreq1() {
		return Freq1;
	}
	public void setFreq1(int freq1) {
		Freq1 = freq1;
	}
	public int getFreq2() {
		return Freq2;
	}
	public void setFreq2(int freq2) {
		Freq2 = freq2;
	}
	public int getFreq3() {
		return Freq3;
	}
	public void setFreq3(int freq3) {
		Freq3 = freq3;
	}
	public int getFreq4() {
		return Freq4;
	}
	public void setFreq4(int freq4) {
		Freq4 = freq4;
	}
	public int getFreq5() {
		return Freq5;
	}
	public void setFreq5(int freq5) {
		Freq5 = freq5;
	}
	public int getFreq6() {
		return Freq6;
	}
	public void setFreq6(int freq6) {
		Freq6 = freq6;
	}
	public int getFreq7() {
		return Freq7;
	}
	public void setFreq7(int freq7) {
		Freq7 = freq7;
	}
	public int getFreq8() {
		return Freq8;
	}
	public void setFreq8(int freq8) {
		Freq8 = freq8;
	}
	public int getFreq9() {
		return Freq9;
	}
	public void setFreq9(int freq9) {
		Freq9 = freq9;
	}
	public int getFreq10() {
		return Freq10;
	}
	public void setFreq10(int freq10) {
		Freq10 = freq10;
	}
	public int getFreq11() {
		return Freq11;
	}
	public void setFreq11(int freq11) {
		Freq11 = freq11;
	}
	public int getFreq12() {
		return Freq12;
	}
	public void setFreq12(int freq12) {
		Freq12 = freq12;
	}
	public int getFreq13() {
		return Freq13;
	}
	public void setFreq13(int freq13) {
		Freq13 = freq13;
	}
	public int getFreq14() {
		return Freq14;
	}
	public void setFreq14(int freq14) {
		Freq14 = freq14;
	}
	public int getFreq15() {
		return Freq15;
	}
	public void setFreq15(int freq15) {
		Freq15 = freq15;
	}
	public Frequence(long id, User user, int freq1, int freq2, int freq3, int freq4, int freq5, int freq6, int freq7,
			int freq8, int freq9, int freq10, int freq11, int freq12, int freq13, int freq14, int freq15) {
		super();
		this.id = id;
		this.user = user;
		Freq1 = freq1;
		Freq2 = freq2;
		Freq3 = freq3;
		Freq4 = freq4;
		Freq5 = freq5;
		Freq6 = freq6;
		Freq7 = freq7;
		Freq8 = freq8;
		Freq9 = freq9;
		Freq10 = freq10;
		Freq11 = freq11;
		Freq12 = freq12;
		Freq13 = freq13;
		Freq14 = freq14;
		Freq15 = freq15;
	}
	public Frequence() {
		super();
	}
	
	  
	
	
}