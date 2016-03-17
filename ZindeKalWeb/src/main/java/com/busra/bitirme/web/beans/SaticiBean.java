package com.busra.bitirme.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.busra.bitirme.commons.entities.Satici;
import com.busra.bitirme.commons.services.web.SaticiService;

@ManagedBean
@ViewScoped
public class SaticiBean {

	@ManagedProperty("#{girisSayfasiBackingBean}")
	private GirisSayfasiBackingBean girisSayfasiBackingBean;
	
	private Satici satici = new Satici();

	public SaticiService saticiService = new SaticiService();

	public void saticiBul() {
		satici = saticiService.saticiBul(girisSayfasiBackingBean.getSaticiMail());
	}

	public String saticiProfilbilgisiGüncelleme() {
		saticiService.saticiBulveGuncelle(satici);

		return "saticiProfil.xhtml?faces-redirect=true";
	}

	public String saticiProfileGit() {

		return "saticiProfil.xhtml?faces-redirect=true";
	}

	public String urunGuncellemeyeGit() {

		return "urunGuncellemeSayfasi.xhtml?faces-redirect=true";
	}

	public String urunEkle() {

		return "urunEklemeSayfasi.xhtml?faces-redirect=true";
	}

	public String urunSilme() {

		return "urunSilmeSayfasi.xhtml?faces-redirect=true";
	}

	public String raporGoruntule() {

		return "raporGoruntulemeSayfasi.xhtml?faces-redirect=true";
	}

	public String yorumSikayetDenetle() {

		return "yorumSikayetDenetlemeSayfasi.xhtml?faces-redirect=true";
	}

	public Satici getSatici() {
		return satici;
	}

	public void setSatici(Satici satici) {
		this.satici = satici;
	}

	public void setGirisSayfasiBackingBean(GirisSayfasiBackingBean girisSayfasiBackingBean) {
		this.girisSayfasiBackingBean = girisSayfasiBackingBean;
	}
	
}
