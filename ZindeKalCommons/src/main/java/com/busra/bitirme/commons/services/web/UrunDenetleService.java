package com.busra.bitirme.commons.services.web;

import java.util.ArrayList;

import com.busra.bitirme.commons.daos.web.UrunDenetleDao;
import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;

public class UrunDenetleService {

	UrunDenetleDao urunDao = new UrunDenetleDao();
	
	public ArrayList<UrunOzellik> urunIsmineGoreAra(String urunIsim){
		return urunDao.urunIsmineGoreAra(urunIsim);
	}
	
	public ArrayList<UrunOzellik> barkodNumarasýnaGoreAra(String barkodNo){
		return urunDao.barkodNumarasýnaGoreAra(barkodNo);
	}
	
	public UrunIcerik urunBarkodunaGoreUrunIcerigiGetir(String barkodNo){
		return urunDao.urunBarkodunaGoreUrunIcerigiGetir(barkodNo);
	}
}