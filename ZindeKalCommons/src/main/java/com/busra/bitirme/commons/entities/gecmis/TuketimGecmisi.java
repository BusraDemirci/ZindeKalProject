package com.busra.bitirme.commons.entities.gecmis;

import java.util.Date;

import javax.persistence.*;

@Entity
public class TuketimGecmisi {
	
	@Id
	@GeneratedValue
	private Long tuketimID;
	private String barkodNo;
	private Date tuketimTarihi;

	public Long getTuketimID() {
		return tuketimID;
	}
	public void setTuketimID(Long tuketimID) {
		this.tuketimID = tuketimID;
	}
	public String getBarkodNo() {
		return barkodNo;
	}
	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}
	public Date getTuketimTarihi() {
		return tuketimTarihi;
	}
	public void setTuketimTarihi(Date tuketimTarihi) {
		this.tuketimTarihi = tuketimTarihi;
	}	
	
}
