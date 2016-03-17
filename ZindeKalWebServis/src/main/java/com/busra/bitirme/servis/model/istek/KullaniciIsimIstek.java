package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class KullaniciIsimIstek {
	
	private String isim;
	
	private String kullaniciMail;
	

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getKullaniciMail() {
		return kullaniciMail;
	}

	public void setKullaniciMail(String kullaniciMail) {
		this.kullaniciMail = kullaniciMail;
	}
	
	

}
