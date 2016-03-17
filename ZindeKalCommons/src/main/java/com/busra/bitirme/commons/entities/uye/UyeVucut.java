package com.busra.bitirme.commons.entities.uye;

import javax.persistence.*;

@Entity
public class UyeVucut {
	
	@Id
	@GeneratedValue
	private Long olcuID;

	private double kilo;
	private double boy;
	private double gogus;
	private double bel;
	private double kalca;
	private double bedenKitleIndeksi;
	private double idealVki;

	public double getBedenKitleIndeksi() {
		return bedenKitleIndeksi;
	}
	public void setBedenKitleIndeksi(double bedenKitleIndeksi) {
		this.bedenKitleIndeksi = bedenKitleIndeksi;
	}
	public Long getOlcuID() {
		return olcuID;
	}
	public void setOlcuID(Long olcuID) {
		this.olcuID = olcuID;
	}
	public double getKilo() {
		return kilo;
	}
	public void setKilo(double kilo) {
		this.kilo = kilo;
	}
	public double getBoy() {
		return boy;
	}
	public void setBoy(double boy) {
		this.boy = boy;
	}
	public double getGogus() {
		return gogus;
	}
	public void setGogus(double gogus) {
		this.gogus = gogus;
	}
	public double getBel() {
		return bel;
	}
	public void setBel(double bel) {
		this.bel = bel;
	}
	public double getKalca() {
		return kalca;
	}
	public void setKalca(double kalca) {
		this.kalca = kalca;
	}
	public double getIdealVki() {
		return idealVki;
	}
	public void setIdealVki(double idealVki) {
		this.idealVki = idealVki;
	}

}
