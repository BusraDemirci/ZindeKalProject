package com.busra.bitirme.commons.entities.uye;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.busra.bitirme.commons.entities.Notlar;
import com.busra.bitirme.commons.entities.Tavsiye;
import com.busra.bitirme.commons.entities.YorumSikayetOneri;
import com.busra.bitirme.commons.entities.alerji.Alerji;
import com.busra.bitirme.commons.entities.gecmis.OkutmaGecmisi;
import com.busra.bitirme.commons.entities.gecmis.TuketimGecmisi;
import com.busra.bitirme.commons.entities.hastalik.Hastalik;

@Entity
public class UyeKimlik {
	
	@Id
	@GeneratedValue
	private Long uyeID;
	private String uyeIsim;
	private String uyeSoyisim;
	private String uyeCinsiyet;
	private String uyeDogumTarihi;
	private String uyeTelefon;
	private String uyeMail;
	private String uyeSifre;
	private String fotograf;
	
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Notlar> notlar;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Tavsiye> tavsiyeler;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<YorumSikayetOneri> yorumSikayetOneri;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private UyeSaglik uyeSaglik;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private UyeVucut uyeVucut;
	
	/*@OneToOne(cascade = {CascadeType.ALL})
	@JoinTable(name = "uyeGunlukIhtiyac", joinColumns = { @JoinColumn(name = "uyeID") }, inverseJoinColumns = { @JoinColumn(name = "ihtiyacID") })
	private GunlukIhtiyac uyeGunlukIhtiyac;*/
	
	/*@OneToOne(cascade = {CascadeType.ALL})
	@JoinTable(name = "uyeGunlukVitamin", joinColumns = { @JoinColumn(name = "uyeID") }, inverseJoinColumns = { @JoinColumn(name = "gunlukID") })
	private GunlukVitamin uyeGunlukVitamin;*/

	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Alerji> alerji;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Hastalik> hastalik;
	
	@ManyToMany(fetch = FetchType.EAGER,  cascade = {CascadeType.ALL})
	private List <OkutmaGecmisi> okutulanUrunler;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private List <TuketimGecmisi> tuketilenUrunler;

	public Long getUyeID() {
		return uyeID;
	}

	public void setUyeID(Long uyeID) {
		this.uyeID = uyeID;
	}

	public String getUyeIsim() {
		return uyeIsim;
	}

	public void setUyeIsim(String uyeIsim) {
		this.uyeIsim = uyeIsim;
	}

	public String getUyeSoyisim() {
		return uyeSoyisim;
	}

	public void setUyeSoyisim(String uyeSoyisim) {
		this.uyeSoyisim = uyeSoyisim;
	}

	public String getUyeCinsiyet() {
		return uyeCinsiyet;
	}

	public void setUyeCinsiyet(String uyeCinsiyet) {
		this.uyeCinsiyet = uyeCinsiyet;
	}

	public String getUyeDogumTarihi() {
		return uyeDogumTarihi;
	}

	public void setUyeDogumTarihi(String uyeDogumTarihi) {
		this.uyeDogumTarihi = uyeDogumTarihi;
	}

	public String getUyeTelefon() {
		return uyeTelefon;
	}

	public void setUyeTelefon(String uyeTelefon) {
		this.uyeTelefon = uyeTelefon;
	}

	public String getUyeMail() {
		return uyeMail;
	}

	public void setUyeMail(String uyeMail) {
		this.uyeMail = uyeMail;
	}

	public String getUyeSifre() {
		return uyeSifre;
	}

	public void setUyeSifre(String uyeSifre) {
		this.uyeSifre = uyeSifre;
	}

	public List<Alerji> getAlerji() {
		return alerji;
	}

	public void setAlerji(List<Alerji> alerji) {
		this.alerji = alerji;
	}

	public List<Hastalik> getHastalik() {
		return hastalik;
	}

	public void setHastalik(List<Hastalik> hastalik) {
		this.hastalik = hastalik;
	}

	public List<OkutmaGecmisi> getOkutulanUrunler() {
		return okutulanUrunler;
	}

	public void setOkutulanUrunler(List<OkutmaGecmisi> okutulanUrunler) {
		this.okutulanUrunler = okutulanUrunler;
	}

	public List<TuketimGecmisi> getTuketilenUrunler() {
		return tuketilenUrunler;
	}

	public void setTuketilenUrunler(List<TuketimGecmisi> tuketilenUrunler) {
		this.tuketilenUrunler = tuketilenUrunler;
	}
	
	public List<Notlar> getNotlar() {
		return notlar;
	}

	public void setNotlar(List<Notlar> notlar) {
		this.notlar = notlar;
	}

	
	public List<YorumSikayetOneri> getYorumSikayetOneri() {
		return yorumSikayetOneri;
	}

	public void setYorumSikayetOneri(List<YorumSikayetOneri> yorumSikayetOneri) {
		this.yorumSikayetOneri = yorumSikayetOneri;
	}

	public UyeSaglik getUyeSaglik() {
		return uyeSaglik;
	}

	public void setUyeSaglik(UyeSaglik uyeSaglik) {
		this.uyeSaglik = uyeSaglik;
	}

	public UyeVucut getUyeVucut() {
		return uyeVucut;
	}

	public void setUyeVucut(UyeVucut uyeVucut) {
		this.uyeVucut = uyeVucut;
	}

	public List<Tavsiye> getTavsiyeler() {
		return tavsiyeler;
	}

	public void setTavsiyeler(List<Tavsiye> tavsiyeler) {
		this.tavsiyeler = tavsiyeler;
	}

	public String getFotograf() {
		return fotograf;
	}

	public void setFotograf(String fotograf) {
		this.fotograf = fotograf;
	}

	/*public GunlukIhtiyac getUyeGunlukIhtiyac() {
		return uyeGunlukIhtiyac;
	}

	public void setUyeGunlukIhtiyac(GunlukIhtiyac uyeGunlukIhtiyac) {
		this.uyeGunlukIhtiyac = uyeGunlukIhtiyac;
	}

	public GunlukVitamin getUyeGunlukVitamin() {
		return uyeGunlukVitamin;
	}

	public void setUyeGunlukVitamin(GunlukVitamin uyeGunlukVitamin) {
		this.uyeGunlukVitamin = uyeGunlukVitamin;
	}*/
}
