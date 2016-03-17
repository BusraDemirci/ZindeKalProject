package com.busra.bitirme.commons.entities.hastalik;
import java.util.List;

import com.busra.bitirme.commons.entities.ilac.*;

import javax.persistence.*;

@Entity
public class Hastalik {

	@Id
	@GeneratedValue
	private Long hastalikID;
	private String hastalikIsim;
	private String hastalikDetay;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "hastalikIlac", joinColumns = { @JoinColumn(name = "hastalikID") }, inverseJoinColumns = { @JoinColumn(name = "ilacID") })
	private List<Ilac> ilac;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	//@JoinTable(name = "uyeHastalik", joinColumns = { @JoinColumn(name = "hastalikID") }, inverseJoinColumns = { @JoinColumn(name = "uyeID") })
	
	public List<Ilac> getIlac() {
		return ilac;
	}
	public void setIlac(List<Ilac> ilac) {
		this.ilac = ilac;
	}
	public Long getHastalikID() {
		return hastalikID;
	}
	public void setHastalikID(Long hastalikID) {
		this.hastalikID = hastalikID;
	}
	public String getHastalikIsim() {
		return hastalikIsim;
	}
	public void setHastalikIsim(String hastalikIsim) {
		this.hastalikIsim = hastalikIsim;
	}
	public String getHastalikDetay() {
		return hastalikDetay;
	}
	public void setHastalikDetay(String hastalikDetay) {
		this.hastalikDetay = hastalikDetay;
	}	
}
