package com.busra.bitirme.commons.services.web;

import com.busra.bitirme.commons.daos.web.SaticiDao;
import com.busra.bitirme.commons.entities.Satici;

public class SaticiService {

	public SaticiDao saticiDao = new SaticiDao();

	public void saticiBulveGuncelle(Satici satici) {
		saticiDao.saticiyiBulVeBilgileriniGuncelle(satici);
	}
	
	public Satici saticiBul(String mail){
		return saticiDao.saticiBul(mail);
	}
}
