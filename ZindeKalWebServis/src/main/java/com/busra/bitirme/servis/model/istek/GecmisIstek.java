package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GecmisIstek {

	private String email;
	
	private String barkodNo;
	
	private String date;

	
	public String getEmail() {
		return email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBarkodNo() {
		return barkodNo;
	}

	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}
}
