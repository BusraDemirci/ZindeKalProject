package com.busra.bitirme.servis.model.cevap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class KullaniciIsimCevap {

	private String isim;
	private String soyisim;
	
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	

	
	
}
