package com.busra.bitirme.servis.model.cevap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfilBilgileriCevap {
	
	private String email;
	private String yeniTel;
	private double yeniKilo;
	private double yeniBoy;
	private double yeniGogus;
	private double yeniBel;
	private double yeniKalca;
	private boolean success;
    private String mesaj;
	
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getYeniTel() {
		return yeniTel;
	}
	public void setYeniTel(String yeniTel) {
		this.yeniTel = yeniTel;
	}
	public double getYeniKilo() {
		return yeniKilo;
	}
	public void setYeniKilo(double yeniKilo) {
		this.yeniKilo = yeniKilo;
	}
	public double getYeniBoy() {
		return yeniBoy;
	}
	public void setYeniBoy(double yeniBoy) {
		this.yeniBoy = yeniBoy;
	}
	public double getYeniGogus() {
		return yeniGogus;
	}
	public void setYeniGogus(double yeniGogus) {
		this.yeniGogus = yeniGogus;
	}
	public double getYeniBel() {
		return yeniBel;
	}
	public void setYeniBel(double yeniBel) {
		this.yeniBel = yeniBel;
	}
	public double getYeniKalca() {
		return yeniKalca;
	}
	public void setYeniKalca(double yeniKalca) {
		this.yeniKalca = yeniKalca;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
}
