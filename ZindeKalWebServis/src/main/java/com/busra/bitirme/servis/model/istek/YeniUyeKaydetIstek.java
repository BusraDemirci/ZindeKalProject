package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class YeniUyeKaydetIstek {
	private String isim;
	private String soyisim;
	private String cinsiyet;
	private String dogumTarihi;
	private String telefon;
	private String email;
	private String sifre;
	private Double boy;
	private Double kilo;
	private Double kalcaOlcusu;
	private Double belOlcusu;
	private Double gogusOlcusu;
	private String fotograf;

	public Double getGogusOlcusu() {
		return gogusOlcusu;
	}

	public void setGogusOlcusu(Double gogusOlcusu) {
		this.gogusOlcusu = gogusOlcusu;
	}

	public Double getKalcaOlcusu() {
		return kalcaOlcusu;
	}

	public void setKalcaOlcusu(Double kalcaOlcusu) {
		this.kalcaOlcusu = kalcaOlcusu;
	}

	public Double getBelOlcusu() {
		return belOlcusu;
	}

	public void setBelOlcusu(Double belOlcusu) {
		this.belOlcusu = belOlcusu;
	}

	public Double getBoy() {
		return boy;
	}

	public void setBoy(Double boy) {
		this.boy = boy;
	}

	public Double getKilo() {
		return kilo;
	}

	public void setKilo(Double kilo) {
		this.kilo = kilo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(String dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFotograf() {
		return fotograf;
	}

	public void setFotograf(String fotograf) {
		this.fotograf = fotograf;
	}
}
