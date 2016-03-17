package com.busra.bitirme.commons.entities.urun;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UrunIcerik {
	
	@Id
	@GeneratedValue
	private Long icerikID;
	
	private String barkodNo;
	private double urunEnerji;
	private double urunProtein;
	private double urunDoymusYag;
	private double urunTransYag;
	private double urunYag;
	private double urunKarbonhidrat;
	private double urunKalsiyum;
	private double urunKolestrol;
	private double urunTuz;
	private double urunSeker;
	private double urunLif;
	private boolean editable;
	
	public String getBarkodNo() {
		return barkodNo;
	}
	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}
	public double getUrunEnerji() {
		return urunEnerji;
	}
	public void setUrunEnerji(double urunEnerji) {
		this.urunEnerji = urunEnerji;
	}
	public double getUrunProtein() {
		return urunProtein;
	}
	public void setUrunProtein(double urunProtein) {
		this.urunProtein = urunProtein;
	}
	public double getUrunDoymusYag() {
		return urunDoymusYag;
	}
	public void setUrunDoymusYag(double urunDoymusYag) {
		this.urunDoymusYag = urunDoymusYag;
	}
	public double getUrunTransYag() {
		return urunTransYag;
	}
	public void setUrunTransYag(double urunTransYag) {
		this.urunTransYag = urunTransYag;
	}
	public double getUrunYag() {
		return urunYag;
	}
	public void setUrunYag(double urunYag) {
		this.urunYag = urunYag;
	}
	public double getUrunKarbonhidrat() {
		return urunKarbonhidrat;
	}
	public void setUrunKarbonhidrat(double urunKarbonhidrat) {
		this.urunKarbonhidrat = urunKarbonhidrat;
	}
	public double getUrunKalsiyum() {
		return urunKalsiyum;
	}
	public void setUrunKalsiyum(double urunKalsiyum) {
		this.urunKalsiyum = urunKalsiyum;
	}
	public double getUrunKolestrol() {
		return urunKolestrol;
	}
	public void setUrunKolestrol(double urunKolestrol) {
		this.urunKolestrol = urunKolestrol;
	}
	public double getUrunTuz() {
		return urunTuz;
	}
	public void setUrunTuz(double urunTuz) {
		this.urunTuz = urunTuz;
	}
	public double getUrunSeker() {
		return urunSeker;
	}
	public void setUrunSeker(double urunSeker) {
		this.urunSeker = urunSeker;
	}
	public double getUrunLif() {
		return urunLif;
	}
	public void setUrunLif(double urunLif) {
		this.urunLif = urunLif;
	}
	public Long getIcerikID() {
		return icerikID;
	}
	public void setIcerikID(Long icerikID) {
		this.icerikID = icerikID;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
