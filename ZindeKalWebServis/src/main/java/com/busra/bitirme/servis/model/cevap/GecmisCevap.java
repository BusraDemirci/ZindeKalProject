package com.busra.bitirme.servis.model.cevap;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.busra.bitirme.commons.entities.urun.UrunOzellik;

@XmlRootElement
public class GecmisCevap {
	
	private List<UrunOzellik> gunlukOkutulanUrunler;
	
	private List<UrunOzellik> haftalikOkutulanUrunler;
	
	private List<UrunOzellik> gunlukTuketilenler;
	
	private List<UrunOzellik> haftalikTuketilenler;

	public List<UrunOzellik> getGunlukOkutulanUrunler() {
		return gunlukOkutulanUrunler;
	}

	public void setGunlukOkutulanUrunler(List<UrunOzellik> gunlukOkutulanUrunler) {
		this.gunlukOkutulanUrunler = gunlukOkutulanUrunler;
	}

	public List<UrunOzellik> getHaftalikOkutulanUrunler() {
		return haftalikOkutulanUrunler;
	}

	public void setHaftalikOkutulanUrunler(List<UrunOzellik> haftalikOkutulanUrunler) {
		this.haftalikOkutulanUrunler = haftalikOkutulanUrunler;
	}

	public List<UrunOzellik> getGunlukTuketilenler() {
		return gunlukTuketilenler;
	}

	public void setGunlukTuketilenler(List<UrunOzellik> gunlukTuketilenler) {
		this.gunlukTuketilenler = gunlukTuketilenler;
	}

	public List<UrunOzellik> getHaftalikTuketilenler() {
		return haftalikTuketilenler;
	}

	public void setHaftalikTuketilenler(List<UrunOzellik> haftalikTuketilenler) {
		this.haftalikTuketilenler = haftalikTuketilenler;
	}
}
