package com.busra.bitirme.commons.services.mobil;

import java.util.ArrayList;

import com.busra.bitirme.commons.daos.mobil.FaydaliBilgilerDao;
import com.busra.bitirme.commons.entities.bilgiler.FaydaliBilgiler;

public class FaydaliBilgilerService {

	FaydaliBilgilerDao faydaDao = new FaydaliBilgilerDao();

	public ArrayList<FaydaliBilgiler> faydaliBilgiler() {

		return faydaDao.faydalibilgileriGetir();

	}
}
