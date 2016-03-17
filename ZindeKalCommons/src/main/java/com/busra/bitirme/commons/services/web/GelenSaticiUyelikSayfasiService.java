package com.busra.bitirme.commons.services.web;

import java.util.ArrayList;

import com.busra.bitirme.commons.daos.web.GelenSaticiUyelikSayfasiDao;
import com.busra.bitirme.commons.entities.Satici;

public class GelenSaticiUyelikSayfasiService {

	public GelenSaticiUyelikSayfasiDao istekDao = new GelenSaticiUyelikSayfasiDao();
	
	public ArrayList<Satici>gelenSaticiUyelikIstekleriniBul(){
		return istekDao.gelenSaticiUyelikIstekleriniBul();
	}
	
	public void onaylananSaticiyiKaydet(Satici onaylanacakSatici){
		istekDao.onaylananSaticiyiKaydet(onaylanacakSatici);
	}
	
	public void saticiReddetveSil(Satici reddedilenSatici){
		istekDao.saticiReddetveSil(reddedilenSatici);
	}
}