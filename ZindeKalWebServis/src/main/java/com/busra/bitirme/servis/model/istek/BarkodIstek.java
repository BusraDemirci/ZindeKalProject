package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BarkodIstek {
	
	private String barkodNo;
	
	private String email;

	public String getBarkodNo() {
		return barkodNo;
	}

	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
