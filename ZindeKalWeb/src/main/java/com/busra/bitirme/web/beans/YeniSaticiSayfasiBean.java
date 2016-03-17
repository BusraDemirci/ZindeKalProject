package com.busra.bitirme.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.busra.bitirme.commons.daos.web.GirisSayfasiDao;
import com.busra.bitirme.commons.entities.Satici;
import com.busra.bitirme.commons.services.web.YeniSaticiSayfasiService;

@ManagedBean
@ViewScoped

public class YeniSaticiSayfasiBean{

	Satici satici = new Satici();
	
	YeniSaticiSayfasiService yeniSaticiSayfasiService = new YeniSaticiSayfasiService();
	GirisSayfasiDao girisSayfasiDao = new GirisSayfasiDao();
	
	@ManagedProperty("#{girisSayfasiBackingBean}")
	private GirisSayfasiBackingBean girisSayfasiBackingBean;
	
	public Satici getSatici() {
		return satici;
	}
	public void setSatici(Satici satici) {
		this.satici = satici;
	}
	
	public String yeniSaticiKaydet(){
		satici.setIsAdmin("0");
		satici.setIsSatici("0");
		satici.setOnayDurumu("0");
		Satici kaydolmakIsteyenSaticiMailKontrol = girisSayfasiDao.mailAdresineGoreBul(satici.getSaticiMail());//mail adresine g�re kay�tl� olup olmad���n� kontrol eden fonk. oldu�undan bir daha yazmad�m, var olan� kulland�m
		if(kaydolmakIsteyenSaticiMailKontrol == null){
			yeniSaticiSayfasiService.yeniSaticiKaydet(satici);
			girisSayfasiBackingBean.setSaticiIsim(satici.getSaticiIsim());
			return "SaticiGiris.xhtml?faces-redirect=true";
		}
		else{//ayn� maile sahip ba�ka sat�c� varsa kay�t sayfas�n� tekrar d�nd�r..
			return "YeniSaticiSayfasi.xhtml?faces-redirect=true";
		}
	}
	public void setGirisSayfasiBackingBean(GirisSayfasiBackingBean girisSayfasiBackingBean) {
		this.girisSayfasiBackingBean = girisSayfasiBackingBean;
	}
}