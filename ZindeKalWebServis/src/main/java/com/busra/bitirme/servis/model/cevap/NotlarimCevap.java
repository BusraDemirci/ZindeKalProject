package com.busra.bitirme.servis.model.cevap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.busra.bitirme.commons.entities.Notlar;

@XmlRootElement
public class NotlarimCevap {
	
	private List<Notlar> notlar = new ArrayList<>();

	public List<Notlar> getNotlar() {
		return notlar;
	}

	public void setNotlar(List<Notlar> notlar) {
		this.notlar = notlar;
	}
}
