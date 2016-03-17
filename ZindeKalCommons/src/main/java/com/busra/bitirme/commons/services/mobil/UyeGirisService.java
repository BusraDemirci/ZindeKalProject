package com.busra.bitirme.commons.services.mobil;

import com.busra.bitirme.commons.daos.mobil.UyeGirisDao;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;

public class UyeGirisService {

	public UyeGirisDao uyeGirisDao = new UyeGirisDao();
	
	public UyeKimlik uyeMaileGoreKontrol(String email){
		return uyeGirisDao.uyeMaileGoreKontrol(email);
	}
	public void uyeKayit(UyeKimlik uye){
		uyeGirisDao.yeniUyeKaydet(uye);
	}
}