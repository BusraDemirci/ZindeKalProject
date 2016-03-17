package com.busra.bitirme.commons.entities;

import javax.persistence.*;

@Entity
public class Notlar {

	@Id
	@GeneratedValue
	private Long notID;
	private String notMetni;

	public Long getNotID() {
		return notID;
	}

	public void setNotID(Long notID) {
		this.notID = notID;
	}

	public String getNotMetni() {
		return notMetni;
	}

	public void setNotMetni(String notMetni) {
		this.notMetni = notMetni;
	}

}
