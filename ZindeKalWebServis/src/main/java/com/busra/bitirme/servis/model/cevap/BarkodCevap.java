package com.busra.bitirme.servis.model.cevap;

import javax.xml.bind.annotation.XmlRootElement;

import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunVitamin;

@XmlRootElement
public class BarkodCevap {
	
	private UrunIcerik icerik;
	
	private boolean durum;
	
	private UrunVitamin vitamin;

	public UrunIcerik getIcerik() {
		return icerik;
	}

	public void setIcerik(UrunIcerik icerik) {
		this.icerik = icerik;
	}

	public boolean getDurum() {
		return durum;
	}

	public void setDurum(boolean durum) {
		this.durum = durum;
	}

	public UrunVitamin getVitamin() {
		return vitamin;
	}

	public void setVitamin(UrunVitamin vitamin) {
		this.vitamin = vitamin;
	}

}
