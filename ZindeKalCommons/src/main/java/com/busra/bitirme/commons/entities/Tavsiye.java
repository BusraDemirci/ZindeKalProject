package com.busra.bitirme.commons.entities;

import javax.persistence.*;

@Entity
public class Tavsiye {
	
	@Id
	@GeneratedValue
	private Long tavsiyeID;
	private String barkodNo;
	private String tavsiye;
	private String ertelemeSuresi;
	private boolean tavsiyeyeUymaDurumu;
	
	public Long getTavsiyeID() {
		return tavsiyeID;
	}
	public void setTavsiyeID(Long tavsiyeID) {
		this.tavsiyeID = tavsiyeID;
	}
	public String getBarkodNo() {
		return barkodNo;
	}
	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}
	public String getTavsiye() {
		return tavsiye;
	}
	public void setTavsiye(String tavsiye) {
		this.tavsiye = tavsiye;
	}
	public String getErtelemeSuresi() {
		return ertelemeSuresi;
	}
	public void setErtelemeSuresi(String ertelemeSuresi) {
		this.ertelemeSuresi = ertelemeSuresi;
	}
	public boolean isTavsiyeyeUymaDurumu() {
		return tavsiyeyeUymaDurumu;
	}
	public void setTavsiyeyeUymaDurumu(boolean tavsiyeyeUymaDurumu) {
		this.tavsiyeyeUymaDurumu = tavsiyeyeUymaDurumu;
	}
	
}
