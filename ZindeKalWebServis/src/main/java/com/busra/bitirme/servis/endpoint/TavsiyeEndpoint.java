package com.busra.bitirme.servis.endpoint;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.Tavsiye;
import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.entities.urun.UrunVitamin;
import com.busra.bitirme.commons.entities.uye.GunlukIhtiyac;
import com.busra.bitirme.commons.entities.uye.GunlukVitamin;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.BarkodService;
import com.busra.bitirme.commons.services.mobil.TavsiyeService;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.commons.services.mobil.UyeService;
import com.busra.bitirme.servis.model.cevap.TavsiyeCevap;
import com.busra.bitirme.servis.model.istek.TavsiyeIstek;
import com.busra.bitirme.servis.model.istek.UyeIstek;

@Path("/tavsiye")
public class TavsiyeEndpoint {

	public TavsiyeService tavsiyeService = new TavsiyeService();

	public BarkodService barkodService = new BarkodService();

	public UyeService uyeService = new UyeService();

	public UyeGirisService uyeGirisService = new UyeGirisService();

	private String icerikTipi;

	@POST
	@Path("/tavsiyeOlustur")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public TavsiyeCevap tavsiyeOlustur(TavsiyeIstek istek) {
		TavsiyeCevap cevap = new TavsiyeCevap();
		UrunOzellik urun = barkodService.barkodNoIleUrunArama(istek.getBarkodNo());
		UrunIcerik icerik = urun.getIcerik();
		UrunVitamin vitamin = urun.getVitamin();
		double yuzde = 0;

		String ilkCumle = urun.getUrunIsim() + " g�nl�k ";
		String ortaCumle = " ihtiyac�n�z� % ";
		String sonCumle = " de�erinde kar��lamaktad�r.";
		DecimalFormat df = new DecimalFormat("#.##");
		while (true) {
			yuzde = rasgeleIndeksUretYuzdeGetir(istek.getBarkodNo(), icerik,
					vitamin);
			if (yuzde != 0) {
				break;
			}
		}

		// String cevap2 =
		hastalikDurum(uyeGirisService.uyeMaileGoreKontrol(istek.getKullaniciMail()), icerik, urun);

		// String tavsiye = ilkCumle + getIcerikTipi() + ortaCumle +
		// df.format(yuzde) + " " + sonCumle + " \n" + cevap2;
		String tavsiye = ilkCumle + getIcerikTipi() + ortaCumle
				+ df.format(yuzde) + " " + sonCumle + " \n";
		cevap.setTavsiye(tavsiye);
		return cevap;
	}

	public double yuzdeHesapla(double gunlukDeger, double urunDeger) {
		return urunDeger / gunlukDeger;
	}

	public TavsiyeCevap hastalikDurum(UyeKimlik uye, UrunIcerik icerik, UrunOzellik ozellik) {
		TavsiyeCevap cevap = new TavsiyeCevap();
		if (uye.getUyeSaglik().isHastalik()) {
			for (int i = 0; i < uye.getHastalik().size(); i++) {
				if (uye.getHastalik().get(i).getHastalikIsim().equals("Seker")) {
					if (icerik.getUrunSeker() > 1) {
						cevap.setSeker("Seker hastas� oldu�unuz i�in, yuksek �eker oranl� besinler t�ketmemelisiniz.");
					}
				} else if (uye.getHastalik().get(i).getHastalikIsim().equals("Tansiyon")) {
					if (icerik.getUrunTuz() > 0) {
						cevap.setTansiyon("Tansiyon hastas� oldu�unuz i�in, tuz i�eren besinler t�ketmemelisiniz.");
					}
				} else if (uye.getHastalik().get(i).getHastalikIsim().equals("Kolestrol")) {
					if (icerik.getUrunKolestrol() > 2 | icerik.getUrunDoymusYag() > 2) {
						cevap.setKolestrol("Kolestrol hastas� oldu�unuz i�in, �r�nlerin ya� oran�na dikkat ederek t�ketmelisiniz.");
					}
				}
				/*
				 * if(uye.getHastalik().get(i).getHastalikIsim().equals("Tansiyon"
				 * )) { cevap.setTavsiye(
				 * "Tansiyon hastas� oldu�unuz i�in, tuzlu besinler t�ketmemelisiniz."
				 * ); }
				 */
			}
		} if (uye.getUyeSaglik().isAlerji()) {
			for (int i = 0; i < uye.getAlerji().size(); i++) {
				if(uye.getAlerji().get(i).getAlerjiIsim().equals("Inek Sutu")){
					if((ozellik.getUrunIcerik().contains("inek s�t�") | ozellik.getUrunIcerik().contains("inek sutu")) | ozellik.getUrunIcerik().contains("s�t")){
						cevap.setAlerji("��eri�inde s�t bulunan bu �r�n� t�ketmemelisiniz.");
					}
				} if(uye.getAlerji().get(i).getAlerjiIsim().equals("Keci Sutu")){
					if(ozellik.getUrunIcerik().contains("ke�i s�t�") | ozellik.getUrunIcerik().contains("keci s�t�")){
						cevap.setAlerji("��eri�inde ke�i s�t� bulunan bu �r�n� t�ketmemelisiniz.");
					}
				} if(uye.getAlerji().get(i).getAlerjiIsim().equals("Koyun Sutu")){
					if(ozellik.getUrunIcerik().contains("koyun s�t�") | ozellik.getUrunIcerik().contains("koyun sutu")){
						cevap.setAlerji("��eri�inde koyun s�t� bulunan bu �r�n� t�ketmemelisiniz.");
					}
				} if(uye.getAlerji().get(i).getAlerjiIsim().equals("Tavuk Eti")){
					if(ozellik.getUrunIcerik().contains("tavuk") | ozellik.getUrunIcerik().contains("tavuk eti")){
						cevap.setAlerji("Tavu�a alerjiniz oldu�undan, bu �r�n� t�ketmemelisiniz.");
					}
				} if(uye.getAlerji().get(i).getAlerjiIsim().equals("F�nd�k")){
					if(ozellik.getUrunIcerik().contains("f�nd�k") | ozellik.getUrunIcerik().contains("findik")){
						cevap.setAlerji("F�nd��a alerjiniz oldu�undan, bu �r�n� t�ketmemelisiniz.");
					}
				} if(uye.getAlerji().get(i).getAlerjiIsim().equals("F�st�k")){
					if(ozellik.getUrunIcerik().contains("f�st�k") | ozellik.getUrunIcerik().contains("fistik")){
						cevap.setAlerji("F�st��a alerjiniz oldu�undan, bu �r�n� t�ketmemelisiniz.");
					}
				} if(uye.getAlerji().get(i).getAlerjiIsim().equals("Badem")){
					if(ozellik.getUrunIcerik().contains("badem")){
						cevap.setAlerji("Bademe alerjiniz oldu�undan, bu �r�n� t�ketmemelisiniz.");
					}
				} if(uye.getAlerji().get(i).getAlerjiIsim().equals("Asit")){
					if(ozellik.getUrunIcerik().contains("asit") | ozellik.getUrunIcerik().contains("kafein") | ozellik.getUrunIcerik().contains("karbondioksit")){
						cevap.setAlerji("Gazl� i�eceklere alerjiniz oldu�undan, bu �r�n� t�ketmemelisiniz.");
					}
				} else{
					
				}
			}
		}

		return cevap;
	}

	public double rasgeleIndeksUretYuzdeGetir(String barkodNo,
			UrunIcerik icerik, UrunVitamin vitamin) {
		GunlukIhtiyac gunlukIhtiyac = tavsiyeService.gunlukBesinIhtiyaciniGetir();
		GunlukVitamin gunlukVitamin = tavsiyeService.gunlukVitaminIhtiyaciniGetir();

		double yuzde = 0;
		Random rand = new Random();
		int indeks = rand.nextInt(13) + 1;

		if (indeks == 0) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeDoymusYag(),
					icerik.getUrunDoymusYag());
			setIcerikTipi("doymu�yag");
		} else if (indeks == 1) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeEnerji(),
					icerik.getUrunEnerji());
			setIcerikTipi("enerji");
		} else if (indeks == 2) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeKalsiyum(),
					icerik.getUrunKalsiyum());
			setIcerikTipi("kalsiyum");
		} else if (indeks == 3) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeKarbonhidrat(),
					icerik.getUrunKarbonhidrat());
			setIcerikTipi("karbonhidrat");
		} else if (indeks == 4) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeKolestrol(),
					icerik.getUrunKolestrol());
			setIcerikTipi("kolestrol");
		} else if (indeks == 5) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeLif(), icerik.getUrunLif());
			setIcerikTipi("lif");
		} else if (indeks == 6) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeProtein(),
					icerik.getUrunProtein());
			setIcerikTipi("protein");
		} else if (indeks == 7) {
			yuzde = yuzdeHesapla(gunlukIhtiyac.getUyeYag(), icerik.getUrunYag());
			setIcerikTipi("ya�");
		} else if (indeks == 8) {
			yuzde = yuzdeHesapla(gunlukVitamin.getVitA(), vitamin.getVitA());
			setIcerikTipi("A vitamini");
		} else if (indeks == 9) {
			yuzde = yuzdeHesapla(gunlukVitamin.getVitB(), vitamin.getVitB());
			setIcerikTipi("B vitamini");
		} else if (indeks == 10) {
			yuzde = yuzdeHesapla(gunlukVitamin.getVitC(), vitamin.getVitC());
			setIcerikTipi("C vitamini");
		} else if (indeks == 11) {
			yuzde = yuzdeHesapla(gunlukVitamin.getVitD(), vitamin.getVitD());
			setIcerikTipi("D vitamini");
		} else if (indeks == 12) {
			yuzde = yuzdeHesapla(gunlukVitamin.getVitE(), vitamin.getVitE());
			setIcerikTipi("E vitamini");
		} else if (indeks == 13) {
			yuzde = yuzdeHesapla(gunlukVitamin.getVitK(), vitamin.getVitK());
			setIcerikTipi("K vitamini");
		}
		return yuzde;
	}

	@POST
	@Path("/tavsiyeKaydet")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public void tavsiyeKaydet(TavsiyeIstek istek) {
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek
				.getKullaniciMail());
		Tavsiye tavsiye = new Tavsiye();
		tavsiye.setBarkodNo(istek.getBarkodNo());
		tavsiye.setErtelemeSuresi(istek.getErtele());
		tavsiye.setTavsiye(istek.getTavsiye());
		tavsiye.setTavsiyeyeUymaDurumu(istek.isTavsiyeUymaDurumu());
		// ArrayList<Tavsiye> tavsiyeList = new ArrayList<>();
		// tavsiyeList.add(tavsiye);
		uye.getTavsiyeler().add(tavsiye);
		tavsiyeService.tavsiyeKaydet(tavsiye);
		uyeService.uyeGuncelle(uye);
	}

	@POST
	@Path("/kullaniciyaOzelTavsiyeGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public List<Tavsiye> kullaniciyaOzelTavsiyeGetir(UyeIstek istek) {
		String email = istek.getEmail();
		List<Tavsiye> tumBilgiler = new ArrayList<Tavsiye>();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(email);
		tumBilgiler = uye.getTavsiyeler();

		return tumBilgiler;
	}

	public String getIcerikTipi() {
		return icerikTipi;
	}

	public void setIcerikTipi(String icerikTipi) {
		this.icerikTipi = icerikTipi;
	}
}