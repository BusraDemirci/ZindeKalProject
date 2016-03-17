package com.busra.bitirme.commons.services.mobil;

import com.busra.bitirme.commons.daos.mobil.YeniUyeKaydetDao;
import com.busra.bitirme.commons.entities.alerji.Alerji;
import com.busra.bitirme.commons.entities.hastalik.Hastalik;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.entities.uye.UyeSaglik;
import com.busra.bitirme.commons.entities.uye.UyeVucut;

public class YeniUyeKaydetService {
	
	YeniUyeKaydetDao yeniuyeDao=new YeniUyeKaydetDao();
	
	public UyeKimlik uyeMaileGoreKontrol(String email){
		return yeniuyeDao.uyeMaileGoreKontrol(email);
	}
	public void uyeKayit(UyeKimlik uye){
		yeniuyeDao.yeniUyeKaydet(uye);
	}
	public void yeniUyeVucutBilgisi(UyeVucut yeniUyeVucut){
		
		yeniuyeDao.yeniUyeVucutBilgisiKaydet(yeniUyeVucut);
	}
	public UyeKimlik uyeIdKontrol(long id){
		return yeniuyeDao.uyeIdKontrol(id);
	}
	public void uyeGuncelle(UyeKimlik uye) {
		yeniuyeDao.uyeGuncelle(uye);
	}
	public void uyeHastalikBilgisiKaydet(Hastalik hasta){
		
		yeniuyeDao.yeniUyeHastalikBilgisiKaydet(hasta);
	}
	public void uyeSaglikBilgileriKaydet(UyeSaglik uyesaglikbilgisi){
		
		yeniuyeDao.yeniUyeSaglikBilgisiKaydet(uyesaglikbilgisi);
	}
	public void uyeAlerjiBilgisiKaydet(Alerji alerji){
		yeniuyeDao.yeniUyeAlerjiBilgisiKaydet(alerji);
		
	}
	
}
