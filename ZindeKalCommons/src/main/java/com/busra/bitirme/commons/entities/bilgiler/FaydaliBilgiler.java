package com.busra.bitirme.commons.entities.bilgiler;

import javax.persistence.*;

@Entity
public class FaydaliBilgiler {
	
	@Id
	@GeneratedValue
	private Long bilgiID;
	private String bilgi;
	
	public Long getBilgiID() {
		return bilgiID;
	}
	public void setBilgiID(Long bilgiID) {
		this.bilgiID = bilgiID;
	}
	public String getBilgi() {
		return bilgi;
	}
	public void setBilgi(String bilgi) {
		this.bilgi = bilgi;
	}
	
	
}
