package com.busra.bitirme.commons.services.mobil;

import com.busra.bitirme.commons.daos.mobil.UyeDao;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;

public class UyeService {
	
	public UyeDao uyeDao = new UyeDao();
	
	public void uyeGuncelle(UyeKimlik uye) {
		uyeDao.uyeGuncelle(uye);
	}

}