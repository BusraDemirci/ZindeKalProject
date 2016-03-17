package com.busra.bitirme.commons.entities.urun;

import javax.persistence.*;

@Entity
public class UrunVitamin {
	
	@Id
	@GeneratedValue
	private Long urunVitaminID;
	
	private double vitA;
	private double vitB;
	private double vitC;
	private double vitD;
	private double vitE;
	private double vitK;
	

	public Long getUrunVitaminID() {
		return urunVitaminID;
	}
	public void setUrunVitaminID(Long urunVitaminID) {
		this.urunVitaminID = urunVitaminID;
	}
	public double getVitA() {
		return vitA;
	}
	public void setVitA(double vitA) {
		this.vitA = vitA;
	}
	public double getVitB() {
		return vitB;
	}
	public void setVitB(double vitB) {
		this.vitB = vitB;
	}
	public double getVitC() {
		return vitC;
	}
	public void setVitC(double vitC) {
		this.vitC = vitC;
	}
	public double getVitD() {
		return vitD;
	}
	public void setVitD(double vitD) {
		this.vitD = vitD;
	}
	public double getVitE() {
		return vitE;
	}
	public void setVitE(double vitE) {
		this.vitE = vitE;
	}
	public double getVitK() {
		return vitK;
	}
	public void setVitK(double vitK) {
		this.vitK = vitK;
	}
}
