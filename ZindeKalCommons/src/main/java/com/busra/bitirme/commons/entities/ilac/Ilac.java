package com.busra.bitirme.commons.entities.ilac;

import javax.persistence.*;

@Entity
public class Ilac {

	@Id
	@GeneratedValue
	private Long ilacID;
	private String ilacIsim;
	private String ilacDetay;
	
	public Long getIlacID() {
		return ilacID;
	}
	public void setIlacID(Long ilacID) {
		this.ilacID = ilacID;
	}
	public String getIlacIsim() {
		return ilacIsim;
	}
	public void setIlacIsim(String ilacIsim) {
		this.ilacIsim = ilacIsim;
	}
	public String getIlacDetay() {
		return ilacDetay;
	}
	public void setIlacDetay(String ilacDetay) {
		this.ilacDetay = ilacDetay;
	}	
}
