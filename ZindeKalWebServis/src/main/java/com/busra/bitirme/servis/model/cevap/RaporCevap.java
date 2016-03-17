package com.busra.bitirme.servis.model.cevap;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.busra.bitirme.commons.entities.urun.UrunIcerik;

@XmlRootElement
public class RaporCevap {

	private ArrayList<UrunIcerik> uyeMaxTuketimListesi;
	
	private ArrayList<UrunIcerik> uyeMaxOkutmaListesi;
	
	private String [] tuketimIsim;

	private String [] okutmaIsim;
	
	public ArrayList<UrunIcerik> getUyeMaxTuketimListesi() {
		return uyeMaxTuketimListesi;
	}

	public void setUyeMaxTuketimListesi(ArrayList<UrunIcerik> uyeMaxTuketimListesi) {
		this.uyeMaxTuketimListesi = uyeMaxTuketimListesi;
	}

	public ArrayList<UrunIcerik> getUyeMaxOkutmaListesi() {
		return uyeMaxOkutmaListesi;
	}

	public void setUyeMaxOkutmaListesi(ArrayList<UrunIcerik> uyeMaxOkutmaListesi) {
		this.uyeMaxOkutmaListesi = uyeMaxOkutmaListesi;
	}

	public String [] getTuketimIsim() {
		return tuketimIsim;
	}

	public void setTuketimIsim(String [] tuketimIsim) {
		this.tuketimIsim = tuketimIsim;
	}

	public String [] getOkutmaIsim() {
		return okutmaIsim;
	}

	public void setOkutmaIsim(String [] okutmaIsim) {
		this.okutmaIsim = okutmaIsim;
	}
}
