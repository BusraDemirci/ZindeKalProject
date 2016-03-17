package com.busra.bitirme.servis.model.cevap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AnasayfaCevap {

	private double vki;
	private double idealVKI;
	private String fotograf;
	
	public double getIdealVKI() {
		return idealVKI;
	}
	public void setIdealVKI(double idealVKI) {
		this.idealVKI = idealVKI;
	}
	public double getVki() {
		return vki;
	}
	public void setVki(double vki) {
		this.vki = vki;
	}
	public String getFotograf() {
		return fotograf;
	}
	public void setFotograf(String fotograf) {
		this.fotograf = fotograf;
	}
}
