package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotlarimIstek {

	private String not;
	
	private String kullaniciMail;

	public String getNot() {
		return not;
	}

	public void setNot(String not) {
		this.not = not;
	}

	public String getKullaniciMail() {
		return kullaniciMail;
	}

	public void setKullaniciMail(String kullaniciMail) {
		this.kullaniciMail = kullaniciMail;
	}
	
}
