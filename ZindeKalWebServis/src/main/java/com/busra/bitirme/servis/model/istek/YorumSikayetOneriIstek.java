package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class YorumSikayetOneriIstek {

	private String konu;
	private String metin;
	private long uyeId;
	private String email;
	
	public String getKonu() {
		return konu;
	}
	public void setKonu(String konu) {
		this.konu = konu;
	}
	public String getMetin() {
		return metin;
	}
	public void setMetin(String metin) {
		this.metin = metin;
	}
	
	public long getUyeId() {
		return uyeId;
	}
	public void setUyeId(long uyeId) {
		this.uyeId = uyeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
