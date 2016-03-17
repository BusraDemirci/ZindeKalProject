package com.busra.bitirme.servis;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Uye {

	private String username;
	
	private String email;
	
	public static Uye create(String username, String email) {
		Uye uye = new Uye();
		uye.setUsername(username);
		uye.setEmail(email);
		return uye;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
