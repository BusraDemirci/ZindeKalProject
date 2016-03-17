package com.busra.bitirme.commons.services.mobil;

import com.busra.bitirme.commons.daos.mobil.BarkodDao;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;

public class BarkodService {

	BarkodDao urunDao = new BarkodDao();
	
	public UrunOzellik barkodNoIleUrunArama (String barkodNo){
		return urunDao.barkodNoIleUrunArama(barkodNo);
	}
	
	public void urunGuncelle(UrunOzellik urun){
		urunDao.urunGuncelle(urun);
	}
}
