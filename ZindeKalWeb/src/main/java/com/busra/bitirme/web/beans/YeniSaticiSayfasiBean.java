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
		Satici kaydolmakIsteyenSaticiMailKontrol = girisSayfasiDao.mailAdresineGoreBul(satici.getSaticiMail());//mail adresine göre kayýtlý olup olmadýðýný kontrol eden fonk. olduðundan bir daha yazmadým, var olaný kullandým
		if(kaydolmakIsteyenSaticiMailKontrol == null){
			yeniSaticiSayfasiService.yeniSaticiKaydet(satici);
			girisSayfasiBackingBean.setSaticiIsim(satici.getSaticiIsim());
			return "SaticiGiris.xhtml?faces-redirect=true";
		}
		else{//ayný maile sahip baþka satýcý varsa kayýt sayfasýný tekrar döndür..
			return "YeniSaticiSayfasi.xhtml?faces-redirect=true";
		}
	}
	public void setGirisSayfasiBackingBean(GirisSayfasiBackingBean girisSayfasiBackingBean) {
		this.girisSayfasiBackingBean = girisSayfasiBackingBean;
	}
}