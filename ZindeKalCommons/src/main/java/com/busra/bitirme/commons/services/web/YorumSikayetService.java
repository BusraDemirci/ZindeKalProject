package com.busra.bitirme.commons.services.web;

import java.util.ArrayList;

import com.busra.bitirme.commons.daos.web.YorumSikayetDao;
import com.busra.bitirme.commons.entities.YorumSikayetOneri;

public class YorumSikayetService {

	YorumSikayetDao yorumSikayetDao = new YorumSikayetDao();

	public ArrayList<YorumSikayetOneri> yorumlariBul() {
		return yorumSikayetDao.yorumlariBul();
	}

	public ArrayList<YorumSikayetOneri> onerileriBul() {
		return yorumSikayetDao.onerileriBul();
	}

	public ArrayList<YorumSikayetOneri> sikayetleriBul() {
		return yorumSikayetDao.sikayetleriBul();
	}

	public void yorumuOnayla(YorumSikayetOneri yorum) {
		yorumSikayetDao.yorumuOnayla(yorum);
	}

	public void sikayetiOnayla(YorumSikayetOneri sikayet) {
		yorumSikayetDao.sikayetiOnayla(sikayet);
	}

	public void oneriyiOnayla(YorumSikayetOneri oneri) {
		yorumSikayetDao.oneriyiOnayla(oneri);
	}
	
}
