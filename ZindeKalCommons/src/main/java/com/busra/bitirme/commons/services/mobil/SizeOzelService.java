package com.busra.bitirme.commons.services.mobil;

import java.util.ArrayList;

import com.busra.bitirme.commons.daos.mobil.SizeOzelDao;
import com.busra.bitirme.commons.entities.bilgiler.SizeOzel;

public class SizeOzelService {

	SizeOzelDao sizeOzelDao = new SizeOzelDao();
	
	public ArrayList<SizeOzel> diyetleIlgiliBilgilerGetir(){
		return sizeOzelDao.diyetleIlgiliBilgilerGetir();
	}
	
	public ArrayList<SizeOzel> hastaliklarlaIlgiliBilgilerGetir(String hastalik){
		return sizeOzelDao.hastaliklarlaIlgiliBilgilerGetir(hastalik);
	}
	
	public ArrayList<SizeOzel> alerjilerleIlgiliBilgilerGetir(String alerji){
		return sizeOzelDao.alerjilerleIlgiliBilgilerGetir(alerji);
	}
}
