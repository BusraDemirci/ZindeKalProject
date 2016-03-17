package com.busra.bitirme.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class GirisSayfasiBackingBean {
	
	private Boolean girisYapildimi;
	
	private String saticiMail;
	
	private String adminIsim;
	
	private String saticiIsim;
	
	private int yeniYorumSikayetOneriSayisi = 0;
	
	private int yeniUyelikIstekSayisi = 0;
	
	@PostConstruct
	public void girisYapildimiKontrolunuDoldur(){
		setGirisYapildimi(false);
	}
	
	public Boolean getGirisYapildimi() {
		return girisYapildimi;
	}

	public void setGirisYapildimi(Boolean girisYapildimi) {
		this.girisYapildimi = girisYapildimi;
	}
	
	public void girisYapilmadiysaAnasayfayaYonlendir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
		if(!getGirisYapildimi()){
			nav.performNavigation("GirisSayfasi.xhtml");
		}
	}

	public String getSaticiMail() {
		return saticiMail;
	}

	public void setSaticiMail(String saticiMail) {
		this.saticiMail = saticiMail;
	}

	public String getAdminIsim() {
		return adminIsim;
	}

	public void setAdminIsim(String adminIsim) {
		this.adminIsim = adminIsim;
	}

	public String getSaticiIsim() {
		return saticiIsim;
	}

	public void setSaticiIsim(String saticiIsim) {
		this.saticiIsim = saticiIsim;
	}

	public int getYeniYorumSikayetOneriSayisi() {
		return yeniYorumSikayetOneriSayisi;
	}

	public void setYeniYorumSikayetOneriSayisi(int yeniYorumSikayetOneriSayisi) {
		this.yeniYorumSikayetOneriSayisi = yeniYorumSikayetOneriSayisi;
	}

	public int getYeniUyelikIstekSayisi() {
		return yeniUyelikIstekSayisi;
	}

	public void setYeniUyelikIstekSayisi(int yeniUyelikIstekSayisi) {
		this.yeniUyelikIstekSayisi = yeniUyelikIstekSayisi;
	}
}

