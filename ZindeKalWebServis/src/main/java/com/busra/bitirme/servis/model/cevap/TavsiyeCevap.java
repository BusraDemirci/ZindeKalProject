package com.busra.bitirme.servis.model.cevap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TavsiyeCevap {
	
	private String tavsiye;
	private String seker;
	private String tansiyon;
	private String kolestrol;
	private String alerji;

	public String getTavsiye() {
		return tavsiye;
	}

	public void setTavsiye(String tavsiye) {
		this.tavsiye = tavsiye;
	}

	public String getSeker() {
		return seker;
	}

	public void setSeker(String seker) {
		this.seker = seker;
	}

	public String getTansiyon() {
		return tansiyon;
	}

	public void setTansiyon(String tansiyon) {
		this.tansiyon = tansiyon;
	}

	public String getKolestrol() {
		return kolestrol;
	}

	public void setKolestrol(String kolestrol) {
		this.kolestrol = kolestrol;
	}

	public String getAlerji() {
		return alerji;
	}

	public void setAlerji(String alerji) {
		this.alerji = alerji;
	}

}
