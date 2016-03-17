package com.busra.bitirme.commons.services.web;

import com.busra.bitirme.commons.daos.web.YeniSaticiSayfasiDao;
import com.busra.bitirme.commons.entities.Satici;

public class YeniSaticiSayfasiService{
	
	YeniSaticiSayfasiDao yeniSaticiSayfasiDao = new YeniSaticiSayfasiDao();
	
	public void yeniSaticiKaydet(Satici satici){
		yeniSaticiSayfasiDao.yeniSaticiKaydet(satici);
	}
}