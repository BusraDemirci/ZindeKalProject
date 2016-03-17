package com.busra.bitirme.servis.endpoint;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.BarkodService;
import com.busra.bitirme.commons.services.mobil.GecmisService;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.servis.model.cevap.RaporCevap;
import com.busra.bitirme.servis.model.istek.RaporIstek;

@Path("/rapor")
public class RaporEndpoint {
	BarkodService urunService = new BarkodService();

	UyeGirisService uyeGirisService = new UyeGirisService();

	GecmisService gecmisService = new GecmisService();

	@POST
	@Path("/tuketilenUrunleriGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public RaporCevap tuketilenUrunleriGetir(RaporIstek istek) {
		RaporCevap cevap = new RaporCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek.getEmail());
		ArrayList<UrunOzellik> uyeTuketimListesi = new ArrayList<>();
		String[] isimArray = new String[4];

		for (int i = 0; i < uye.getTuketilenUrunler().size(); i++) {
			uyeTuketimListesi.add(gecmisService.barkodnoyaGoreOkutulanUrunOzellikleriniGetir(uye.getTuketilenUrunler().get(i).getBarkodNo()));
		}
		ArrayList<UrunIcerik> uyeMaxTuketimListesi = enCokTuketilenUrunleriBul(uyeTuketimListesi);

		for (int i = 0; i < uyeMaxTuketimListesi.size(); i++) {
			isimArray[i] = urunService.barkodNoIleUrunArama(
					uyeMaxTuketimListesi.get(i).getBarkodNo()).getUrunIsim();
		}
		cevap.setUyeMaxTuketimListesi(uyeMaxTuketimListesi);
		cevap.setTuketimIsim(isimArray);
		return cevap;
	}

	@POST
	@Path("/okutulanUrunleriGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public RaporCevap okutulanUrunleriGetir(RaporIstek istek) {
		RaporCevap cevap = new RaporCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek.getEmail());
		ArrayList<UrunOzellik> uyeOkutmaListesi = new ArrayList<>();
		String[] isimArray = new String[4];

		for (int i = 0; i < uye.getOkutulanUrunler().size(); i++) {
			uyeOkutmaListesi.add(gecmisService.barkodnoyaGoreOkutulanUrunOzellikleriniGetir(uye.getOkutulanUrunler().get(i).getBarkodNo()));
		}
		ArrayList<UrunIcerik> uyeMaxOkutmaListesi = enCokOkutulanUrunleriBul(uyeOkutmaListesi);
		for (int i = 0; i < uyeMaxOkutmaListesi.size(); i++) {
			isimArray[i] = urunService.barkodNoIleUrunArama(
					uyeMaxOkutmaListesi.get(i).getBarkodNo()).getUrunIsim();
		}
		cevap.setUyeMaxOkutmaListesi(uyeMaxOkutmaListesi);
		cevap.setOkutmaIsim(isimArray);
		return cevap;
	}

	public ArrayList<UrunIcerik> enCokOkutulanUrunleriBul(ArrayList<UrunOzellik> urunList) {
		
		ArrayList<UrunIcerik> enBuyukler = new ArrayList<>();

		int sayac = 4;
		int max = -1;
		int indeks = 0;
		String maxisim = "";

		if (urunList.size() < 4) {
			if (urunList.size() == 3) {
				sayac = 3;
			} else if (urunList.size() == 2) {
				sayac = 2;
			} else if (urunList.size() == 1) {
				sayac = 1;
			} else {
				sayac = 0;
			}
		}

		for (int i = 0; i < sayac; i++) {
			for (int j = 0; j < urunList.size(); j++) {
					if (urunList.get(j).getOkutmaSayaci() >= max) {
						max = urunList.get(j).getOkutmaSayaci();
						maxisim = urunList.get(j).getUrunIsim();
						indeks = j;
						max = -1;
					}
			}
			
			int sizeTemp = 0;
			
			enBuyukler.add(urunList.get(indeks).getIcerik());

			for (int j = sizeTemp; j < urunList.size(); j++) {
				if (maxisim.equals(urunList.get(j).getUrunIsim())) {
					urunList.remove(j);
					j = j - 1;
				}
			}
			
			
		}

		return enBuyukler;
	}

	public ArrayList<UrunIcerik> enCokTuketilenUrunleriBul(ArrayList<UrunOzellik> urunList) {
		
		ArrayList<UrunIcerik> enBuyukler = new ArrayList<>();

		int sayac = 4;
		int max = -1;
		int indeks = 0;
		String maxisim = "";

		if (urunList.size() < 4) {
			if (urunList.size() == 3) {
				sayac = 3;
			} else if (urunList.size() == 2) {
				sayac = 2;
			} else if (urunList.size() == 1) {
				sayac = 1;
			} else {
				sayac = 0;
			}
		}

		for (int i = 0; i < sayac; i++) {
			for (int j = 0; j < urunList.size(); j++) {
					if (urunList.get(j).getTuketimSayaci() >= max) {
						max = urunList.get(j).getTuketimSayaci();
						maxisim = urunList.get(j).getUrunIsim();
						indeks = j;
						max = -1;
					}
			}
			
			int sizeTemp = 0;
			
			enBuyukler.add(urunList.get(indeks).getIcerik());

			for (int j = sizeTemp; j < urunList.size(); j++) {
				if (maxisim.equals(urunList.get(j).getUrunIsim())) {
					urunList.remove(j);
					j = j - 1;
				}
			}
			
			
		}

		return enBuyukler;
	}
}
