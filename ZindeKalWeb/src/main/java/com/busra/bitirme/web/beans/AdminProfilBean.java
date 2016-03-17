package com.busra.bitirme.web.beans;

import java.awt.event.ActionEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.busra.bitirme.commons.entities.Satici;
import com.busra.bitirme.commons.services.web.AdminService;


@ManagedBean
@ViewScoped
public class AdminProfilBean {
	
	public Satici admin = new Satici();
	
	public AdminService adminServis = new AdminService();
	
	@ManagedProperty("#{girisSayfasiBackingBean}")
	private GirisSayfasiBackingBean girisSayfasiBackingBean;
	
	@PostConstruct public void adminProfilBilgiTextiniDoldur(){		
		setAdmin(adminServis.adminBilgileriniGetir());
	}
	
	public String adminProfilBilgileriGuncelle(ActionEvent event){
		admin.setSaticiIsim(admin.getSaticiIsim());
		admin.setSaticiSoyIsim(admin.getSaticiSoyIsim());
		admin.setSaticiKimlikNo(admin.getSaticiKimlikNo());
		admin.setSaticiMail(admin.getSaticiMail());
		admin.setSaticiTelefon(admin.getSaticiTelefon());
		adminServis.adminiBulveGuncelle(admin);
		return "AdminProfil.xhtml?faces-redirect=true";
	}
	
	public String iptal(){		
		return "AdminGirisSayfasi.xhtml?faces-redirect=true";
	}
	
	public Satici getAdmin() {
		return admin;
	}

	public void setAdmin(Satici admin) {
		this.admin = admin;
	}

	public void setGirisSayfasiBackingBean(GirisSayfasiBackingBean girisSayfasiBackingBean) {
		this.girisSayfasiBackingBean = girisSayfasiBackingBean;
	}
}