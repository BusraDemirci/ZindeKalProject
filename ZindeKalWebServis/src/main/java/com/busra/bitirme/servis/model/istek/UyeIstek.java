package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UyeIstek {

	private String email;
	
	private String foto;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}	
}
