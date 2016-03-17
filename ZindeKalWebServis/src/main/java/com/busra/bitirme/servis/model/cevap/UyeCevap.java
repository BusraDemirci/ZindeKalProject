package com.busra.bitirme.servis.model.cevap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UyeCevap {

	private boolean success;

	private String mesaj;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
}
