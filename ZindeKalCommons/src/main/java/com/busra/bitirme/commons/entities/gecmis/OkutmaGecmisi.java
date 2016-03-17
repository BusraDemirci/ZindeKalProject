package com.busra.bitirme.commons.entities.gecmis;

import java.util.Date;

import javax.persistence.*;

@Entity
public class OkutmaGecmisi {
	
	@Id
	@GeneratedValue
	private Long okutmaGecmisID;
	private String barkodNo;
	private Date okutmaTarihi;
	private boolean satinAlmaDurumu;
	
	public Long getOkutmaGecmisID() {
		return okutmaGecmisID;
	}
	public void setOkutmaGecmisID(Long okutmaGecmisID) {
		this.okutmaGecmisID = okutmaGecmisID;
	}
	public String getBarkodNo() {
		return barkodNo;
	}
	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}
	public Date getOkutmaTarihi() {
		return okutmaTarihi;
	}
	public void setOkutmaTarihi(Date okutmaTarihi) {
		this.okutmaTarihi = okutmaTarihi;
	}
	public boolean isSatinAlmaDurumu() {
		return satinAlmaDurumu;
	}
	public void setSatinAlmaDurumu(boolean satinAlmaDurumu) {
		this.satinAlmaDurumu = satinAlmaDurumu;
	}

}
