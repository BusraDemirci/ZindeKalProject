package com.busra.bitirme.commons.entities.alerji;

import java.util.List;

import javax.persistence.*;

import com.busra.bitirme.commons.entities.ilac.*;

@Entity
public class Alerji {
	
	@Id
	@GeneratedValue
	private Long alerjiID;
	private String alerjiIsim;	
	private String alerjiDetay;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	//@JoinTable(name = "alerji_ilac", joinColumns = { @JoinColumn(name = "alerjiID") }, inverseJoinColumns = { @JoinColumn(name = "ilacID") })
	private List<Ilac> ilac;
	
	public List<Ilac> getIlac() {
		return ilac;
	}
	public void setIlac(List<Ilac> ilac) {
		this.ilac = ilac;
	}
	public Long getAlerjiID() {
		return alerjiID;
	}
	public void setAlerjiID(Long alerjiID) {
		this.alerjiID = alerjiID;
	}
	public String getAlerjiIsim() {
		return alerjiIsim;
	}
	public void setAlerjiIsim(String alerjiIsim) {
		this.alerjiIsim = alerjiIsim;
	}
	public String getAlerjiDetay() {
		return alerjiDetay;
	}
	public void setAlerjiDetay(String alerjiDetay) {
		this.alerjiDetay = alerjiDetay;
	}
}
