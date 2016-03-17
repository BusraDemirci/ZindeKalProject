package com.busra.bitirme.commons.services.mobil;

import com.busra.bitirme.commons.daos.mobil.GecmisDao;
import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;

public class GecmisService {
	
	GecmisDao gecmisDao = new GecmisDao();

	public UrunOzellik barkodnoyaGoreOkutulanUrunOzellikleriniGetir(String barkodNo){
		return gecmisDao.barkodnoyaGoreOkutulanUrunOzellikleriniGetir(barkodNo);
	}
	
	public UrunIcerik barkodnoyaGoreOkutulanUrunIceriginiGetir(String barkodNo){
		return gecmisDao.barkodnoyaGoreOkutulanUrunIceriginiGetir(barkodNo);
	}
}
