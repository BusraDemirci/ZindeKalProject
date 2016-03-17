package com.busra.bitirme.commons.entities.uye;

import javax.persistence.*;

@Entity
public class UyeSaglik {
	
	@Id
	@GeneratedValue
	private Long saglikDurumuID;
		
	private boolean isDiyet;
	private boolean isHastalik;
	private boolean isAlerji;

	public Long getSaglikDurumuID() {
		return saglikDurumuID;
	}
	public void setSaglikDurumuID(Long saglikDurumuID) {
		this.saglikDurumuID = saglikDurumuID;
	}
	public boolean isDiyet() {
		return isDiyet;
	}
	public void setDiyet(boolean isDiyet) {
		this.isDiyet = isDiyet;
	}
	public boolean isHastalik() {
		return isHastalik;
	}
	public void setHastalik(boolean isHastalik) {
		this.isHastalik = isHastalik;
	}
	public boolean isAlerji() {
		return isAlerji;
	}
	public void setAlerji(boolean isAlerji) {
		this.isAlerji = isAlerji;
	}
}
