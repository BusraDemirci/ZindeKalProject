package com.busra.bitirme.commons.services.web;

import java.util.ArrayList;

import com.busra.bitirme.commons.daos.web.UrunDao;
import com.busra.bitirme.commons.entities.Tavsiye;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.entities.urun.UrunIcerik;

public class UrunService {

	UrunDao urunDao = new UrunDao();

	public void urunEkle(UrunOzellik urunozellik) {

		urunDao.urunEkle(urunozellik);
	}

	public void urunGuncelle(ArrayList<UrunOzellik> guncelUrunOzellikleri, ArrayList<UrunIcerik> guncelUrunIcerikleri) {

		urunDao.urunGuncelle(guncelUrunOzellikleri, guncelUrunIcerikleri);

	}

	public void urunGuncelle(UrunOzellik guncelUrun) {

		urunDao.urunGuncelle(guncelUrun);

	}

	public boolean urunSil(ArrayList<UrunOzellik> silinecekUrunOzellikleri) {
		boolean deleteResult = urunDao.urunSil(silinecekUrunOzellikleri);
		return deleteResult;
	}

	public UrunOzellik barkodNoIleUrunArama(String barkodNo) {
		UrunOzellik urunOzellik = new UrunOzellik();
		urunOzellik = urunDao.barkodNoIleUrunArama(barkodNo);
		return urunOzellik;
	}

	public ArrayList<UrunOzellik> urunIsimIleUrunArama(String urunIsim) {
		ArrayList<UrunOzellik> urunOzellikList = new ArrayList<UrunOzellik>();
		urunOzellikList = urunDao.urunIsmiIleOzellikDondur(urunIsim);
		return urunOzellikList;
	}

	public UrunIcerik barkodNoyaGoreIcerikdondur(String barkodNo) {
		UrunIcerik urunIcerik = new UrunIcerik();
		urunIcerik = urunDao.barkodNoyaGoreIcerikdondur(barkodNo);
		return urunIcerik;
	}

	public UrunOzellik raporTüketim() {
		ArrayList<UrunOzellik> urunList = urunDao.enCokOkutulanveTuketilenUrunuBul();
		UrunOzellik enCokTuketilenUrun = new UrunOzellik();
		int max = -1;
		
			for (int j = 0; j < urunList.size(); j++) {
				if (urunList.get(j).getTuketimSayaci() >= max) {
					enCokTuketilenUrun = urunList.get(j);
					max = enCokTuketilenUrun.getTuketimSayaci();
				}
			}
			
			return enCokTuketilenUrun;
	}

	public UrunOzellik raporOkutma() {
		ArrayList<UrunOzellik> urunList = urunDao.enCokOkutulanveTuketilenUrunuBul();
		UrunOzellik enCokOkutulanUrun = new UrunOzellik();
		int max = -1;
		
			for (int j = 0; j < urunList.size(); j++) {
				if (urunList.get(j).getOkutmaSayaci() >= max) {
					enCokOkutulanUrun = urunList.get(j);
					max = enCokOkutulanUrun.getOkutmaSayaci();
				}
			}
			
			return enCokOkutulanUrun;
	}
	
	
	public double tavsiyeyeUymaOraniniBul(){
		ArrayList<Tavsiye> tavsiyeList = urunDao.tavsiyeTablosunuDondur();
		int uyduSayac = 0;
		double tavsiyeyeUymaOrani = 0;
		
		for(int i=0; i<tavsiyeList.size(); i++){
			if(tavsiyeList.get(i).isTavsiyeyeUymaDurumu() == true){
				uyduSayac ++;
			}
		}
		tavsiyeyeUymaOrani = (uyduSayac / tavsiyeList.size()) * 100;
		
		return tavsiyeyeUymaOrani;
	}
}