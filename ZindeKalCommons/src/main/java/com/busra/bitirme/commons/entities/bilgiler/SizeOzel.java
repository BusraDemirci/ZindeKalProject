package com.busra.bitirme.commons.entities.bilgiler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SizeOzel {
	
	@Id
	@GeneratedValue
	private Long bilgiID;
	private String bilgiKonusu;
	private String bilgiMetni;
	
	
	public Long getBilgiID() {
		return bilgiID;
	}
	public void setBilgiID(Long bilgiID) {
		this.bilgiID = bilgiID;
	}
	public String getBilgiKonusu() {
		return bilgiKonusu;
	}
	public void setBilgiKonusu(String bilgiKonusu) {
		this.bilgiKonusu = bilgiKonusu;
	}
	public String getBilgiMetni() {
		return bilgiMetni;
	}
	public void setBilgiMetni(String bilgiMetni) {
		this.bilgiMetni = bilgiMetni;
	}
}
