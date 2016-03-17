package com.busra.bitirme.commons.entities.uye;

import javax.persistence.*;

@Entity
public class GunlukIhtiyac {

	@Id
	@GeneratedValue
	private Long ihtiyacID;
	//private Long uyeID;
	private double uyeEnerji;
	private double uyeProtein;
	private double uyeDoymusYag;
	private double uyeYag;
	private double uyeKarbonhidrat;
	private double uyeKalsiyum;
	private double uyeKolestrol;
	private double uyeTuz;
	private double uyeSeker;
	private double uyeLif;
	
	public Long getIhtiyacID() {
		return ihtiyacID;
	}
	public void setIhtiyacID(Long ihtiyacID) {
		this.ihtiyacID = ihtiyacID;
	}

	/*public Long getUyeID() {
		return uyeID;
	}
	public void setUyeID(Long uyeID) {
		this.uyeID = uyeID;
	}*/
	public double getUyeEnerji() {
		return uyeEnerji;
	}
	public void setUyeEnerji(double uyeEnerji) {
		this.uyeEnerji = uyeEnerji;
	}
	public double getUyeProtein() {
		return uyeProtein;
	}
	public void setUyeProtein(double uyeProtein) {
		this.uyeProtein = uyeProtein;
	}
	public double getUyeDoymusYag() {
		return uyeDoymusYag;
	}
	public void setUyeDoymusYag(double uyeDoymusYag) {
		this.uyeDoymusYag = uyeDoymusYag;
	}
	public double getUyeYag() {
		return uyeYag;
	}
	public void setUyeYag(double uyeYag) {
		this.uyeYag = uyeYag;
	}
	public double getUyeKarbonhidrat() {
		return uyeKarbonhidrat;
	}
	public void setUyeKarbonhidrat(double uyeKarbonhidrat) {
		this.uyeKarbonhidrat = uyeKarbonhidrat;
	}
	public double getUyeKalsiyum() {
		return uyeKalsiyum;
	}
	public void setUyeKalsiyum(double uyeKalsiyum) {
		this.uyeKalsiyum = uyeKalsiyum;
	}
	public double getUyeKolestrol() {
		return uyeKolestrol;
	}
	public void setUyeKolestrol(double uyeKolestrol) {
		this.uyeKolestrol = uyeKolestrol;
	}
	public double getUyeTuz() {
		return uyeTuz;
	}
	public void setUyeTuz(double uyeTuz) {
		this.uyeTuz = uyeTuz;
	}
	public double getUyeSeker() {
		return uyeSeker;
	}
	public void setUyeSeker(double uyeSeker) {
		this.uyeSeker = uyeSeker;
	}
	public double getUyeLif() {
		return uyeLif;
	}
	public void setUyeLif(double uyeLif) {
		this.uyeLif = uyeLif;
	}

}
