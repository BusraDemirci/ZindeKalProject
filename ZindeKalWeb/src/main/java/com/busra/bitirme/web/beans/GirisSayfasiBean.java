package com.busra.bitirme.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.busra.bitirme.commons.entities.Satici;
import com.busra.bitirme.commons.services.web.AdminService;
import com.busra.bitirme.commons.services.web.GirisSayfasiService;
import com.busra.bitirme.commons.services.web.SaticiService;

@ManagedBean
@SessionScoped
public class GirisSayfasiBean {

	public Satici satici = new Satici();

	public FacesContext f = FacesContext.getCurrentInstance();
	
	public AdminService adminServis = new AdminService();

	// buraya bi tane property koy ve her sayfada kontrolünü yap bu özellik dolu
	// ise giriþ yapabilsin yeni bean ile

	public GirisSayfasiService girisSayfasiService = new GirisSayfasiService();

	@ManagedProperty("#{girisSayfasiBackingBean}")
	private GirisSayfasiBackingBean girisSayfasiBackingBean;

	public SaticiService saticiService = new SaticiService();

	public Satici getSatici() {
		return satici;
	}

	public void setSatici(Satici satici) {
		this.satici = satici;
	}

	public FacesContext getF() {
		return f;
	}

	public void setF(FacesContext f) {
		this.f = f;
	}

	public String kullaniciRoluneGoreSayfaYonlendirme() {
		String kullaniciGirilenMail = satici.getSaticiMail();
		String kullaniciGirilenSifre = satici.getSaticiSifre();
		Satici kontrolEdilecekSatici = girisSayfasiService.kullaniciDogrulama(kullaniciGirilenMail, kullaniciGirilenSifre);
		String kullaniciRolu = "";
		String isAdmin = "";
		String isSatici = "";
		String onayDurumu = "";

		if (kontrolEdilecekSatici == null) {
			kullaniciRolu = "hataliMail";
		} else {
			isAdmin = kontrolEdilecekSatici.getIsAdmin();
			isSatici = kontrolEdilecekSatici.getIsSatici();
			onayDurumu = kontrolEdilecekSatici.getOnayDurumu();
			String kullaniciSistemdeKayitliSifre = kontrolEdilecekSatici.getSaticiSifre();

			if (kullaniciGirilenSifre.equals(kullaniciSistemdeKayitliSifre)) {
				if (isAdmin.equals("1")) {
					kullaniciRolu = "admin";
					girisSayfasiBackingBean.setAdminIsim(kontrolEdilecekSatici.getSaticiIsim());
					girisSayfasiBackingBean.setGirisYapildimi(true);
				} else if (isSatici.equals("1")) {
					kullaniciRolu = "satici";
					girisSayfasiBackingBean.setSaticiIsim(kontrolEdilecekSatici.getSaticiIsim());
					girisSayfasiBackingBean.setGirisYapildimi(true);
				} else {
					if (isSatici.equals("0") || onayDurumu.equals("0")) {
						kullaniciRolu = "onaylanmamisSatici";
					}
				}
			} else {
				kullaniciRolu = "hataliSifre";
			}
		}
		if (kullaniciRolu.equals("satici")) {
			girisSayfasiBackingBean.setSaticiMail(satici.getSaticiMail());
			girisSayfasiBackingBean.setGirisYapildimi(true);
			return "SaticiGiris.xhtml?faces-redirect=true";
		} else if (kullaniciRolu.equals("admin")) {
			//girisSayfasiBackingBean.setGirisYapildimi(true);
			return "AdminProfil.xhtml?faces-redirect=true";
		} else if (kullaniciRolu.equals("onaylanmamisSatici")) {
			//girisSayfasiBackingBean.setGirisYapildimi(false);
			facesMesajOlustur("Üyeliðiniz onaylanmamýþtýr, lütfen üyeliðinizin sistem yöneticisi tarafýndan onaylanmasýný bekleyiniz.", "onaylanmamis");
		} else if (kullaniciRolu.equals("hataliMail")) {
			//girisSayfasiBackingBean.setGirisYapildimi(false);
			facesMesajOlustur("Bilgilerinizi kontrol ederek tekrar giriþ yapýnýz.", "email");
		} else if (kullaniciRolu.equals("hataliSifre")) {
			//girisSayfasiBackingBean.setGirisYapildimi(false);
			facesMesajOlustur("Þifrenizi kontrol ederek tekrar giriþ yapýnýz.", "sifre");
		} else {
			return "GirisSayfasi.xhtml?faces-redirect=true";
		}
		return null;
	}

	public void facesMesajOlustur(String mesaj, String kontrol) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(mesaj);
		if (kontrol.equals("email")) {
			facesContext.addMessage("form:email", facesMessage);
		} else if (kontrol.equals("sifre")) {
			facesContext.addMessage("form:sifre", facesMessage);
		} else if (kontrol.equals("onaylanmamis")) {
			facesContext.addMessage("form:email", facesMessage);
		} else {
			facesContext.addMessage(null, facesMessage);
		}
	}
	public void setGirisSayfasiBackingBean(GirisSayfasiBackingBean girisSayfasiBackingBean) {
		this.girisSayfasiBackingBean = girisSayfasiBackingBean;
	}
}