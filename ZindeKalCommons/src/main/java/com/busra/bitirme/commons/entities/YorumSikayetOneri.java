package com.busra.bitirme.commons.entities;

import javax.persistence.*;

@Entity
public class YorumSikayetOneri {
	
	@Id
	@GeneratedValue
	private Long yorumSikayetOneriID;
	private String konu;
	private String metin;
	private String turu;
	private String isGoruldu;
	
	public String getIsGoruldu() {
		return isGoruldu;
	}
	public void setIsGoruldu(String isGoruldu) {
		this.isGoruldu = isGoruldu;
	}
	public Long getYorumSikayetOneriID() {
		return yorumSikayetOneriID;
	}
	public void setYorumSikayetOneriID(Long yorumSikayetOneriID) {
		this.yorumSikayetOneriID = yorumSikayetOneriID;
	}
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
	public String getTuru() {
		return turu;
	}
	public void setTuru(String turu) {
		this.turu = turu;
	}
}
