package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TavsiyeIstek {

	private String tavsiye;
	private String kullaniciMail;
	private String ertele;
	private boolean tavsiyeUymaDurumu = false;
	private String barkodNo;

	public String getTavsiye() {
		return tavsiye;
	}

	public void setTavsiye(String tavsiye) {
		this.tavsiye = tavsiye;
	}

	public String getKullaniciMail() {
		return kullaniciMail;
	}

	public void setKullaniciMail(String kullaniciMail) {
		this.kullaniciMail = kullaniciMail;
	}

	public String getErtele() {
		return ertele;
	}

	public void setErtele(String ertele) {
		this.ertele = ertele;
	}

	public boolean isTavsiyeUymaDurumu() {
		return tavsiyeUymaDurumu;
	}

	public void setTavsiyeUymaDurumu(boolean tavsiyeUymaDurumu) {
		this.tavsiyeUymaDurumu = tavsiyeUymaDurumu;
	}

	public String getBarkodNo() {
		return barkodNo;
	}

	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}
}
