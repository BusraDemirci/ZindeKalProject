package com.busra.bitirme.commons.services.mobil;

import com.busra.bitirme.commons.daos.mobil.TavsiyeDao;
import com.busra.bitirme.commons.entities.Tavsiye;
import com.busra.bitirme.commons.entities.uye.GunlukIhtiyac;
import com.busra.bitirme.commons.entities.uye.GunlukVitamin;

public class TavsiyeService {

	TavsiyeDao tavsiyeDao = new TavsiyeDao();

	public GunlukVitamin gunlukVitaminIhtiyaciniGetir() {
		return tavsiyeDao.gunlukVitaminIhtiyaciniGetir();
	}

	public GunlukIhtiyac gunlukBesinIhtiyaciniGetir() {
		return tavsiyeDao.gunlukBesinIhtiyaciniGetir();
	}

	public void tavsiyeKaydet(Tavsiye tavsiye) {
		tavsiyeDao.tavsiyeKaydet(tavsiye);
	}
}
