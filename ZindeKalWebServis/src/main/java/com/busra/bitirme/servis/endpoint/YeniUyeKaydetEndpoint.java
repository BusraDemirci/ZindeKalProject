package com.busra.bitirme.servis.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.alerji.Alerji;
import com.busra.bitirme.commons.entities.hastalik.Hastalik;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.entities.uye.UyeSaglik;
import com.busra.bitirme.commons.entities.uye.UyeVucut;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.commons.services.mobil.UyeService;
import com.busra.bitirme.commons.services.mobil.YeniUyeKaydetService;
import com.busra.bitirme.servis.model.istek.*;
import com.busra.bitirme.servis.model.cevap.*;

@Path("/yeniUyeKaydet")
public class YeniUyeKaydetEndpoint {

	YeniUyeKaydetService yeniUyeService = new YeniUyeKaydetService();

	UyeService uyeService = new UyeService();

	UyeGirisService uyeGirisService = new UyeGirisService();

	@POST
	@Path("/uyeKayit")
	@Produces("application/json; charset=utf-8")
	@Consumes("application/json; charset=utf-8")
	public Long uyeKayit(YeniUyeKaydetIstek uyeOlmaIstek) {
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(uyeOlmaIstek.getEmail());
		YeniUyeKaydetCevap cevap = new YeniUyeKaydetCevap();
		
		if (uye != null) {
			cevap.setSuccess(false);
			cevap.setMesaj("Bu mail adresi sistemde zaten kullanýlmaktadýr.");
		} else {
			uye = new UyeKimlik();
			uye.setUyeIsim(uyeOlmaIstek.getIsim());
			uye.setUyeSoyisim(uyeOlmaIstek.getSoyisim());
			uye.setUyeCinsiyet(uyeOlmaIstek.getCinsiyet());
			uye.setUyeDogumTarihi(uyeOlmaIstek.getDogumTarihi());
			uye.setUyeMail(uyeOlmaIstek.getEmail());
			uye.setUyeSifre(uyeOlmaIstek.getSifre());
			uye.setUyeTelefon(uyeOlmaIstek.getTelefon());
			uye.setFotograf(uyeOlmaIstek.getFotograf());

			yeniUyeService.uyeKayit(uye);

			UyeVucut uyeVucut = new UyeVucut();
			uyeVucut.setBedenKitleIndeksi(bedenKitleHesapla(uyeOlmaIstek.getKilo(), uyeOlmaIstek.getBoy()));
			uyeVucut.setBel(uyeOlmaIstek.getBelOlcusu());
			uyeVucut.setBoy(uyeOlmaIstek.getBoy());
			uyeVucut.setGogus(uyeOlmaIstek.getGogusOlcusu());
			uyeVucut.setKalca(uyeOlmaIstek.getKalcaOlcusu());
			uyeVucut.setKilo(uyeOlmaIstek.getKilo());
			//uyeVucut.setOlcuID(uye.getUyeID());
			
			if(uye.getUyeCinsiyet() == "Bayan"){
				uyeVucut.setIdealVki(uyeOlmaIstek.getBoy() - 110);
			}else{
				uyeVucut.setIdealVki(uyeOlmaIstek.getBoy() - 100);
			}

			uye.setUyeVucut(uyeVucut);
			uye.setAlerji(null);
			uye.setHastalik(null);
			uye.setOkutulanUrunler(null);
			uye.setNotlar(null);
			uye.setTuketilenUrunler(null);
			// uye.setUyeGunlukIhtiyac(null);
			// uye.setUyeGunlukVitamin(null);
			uye.setUyeSaglik(null);
			uye.setYorumSikayetOneri(null);

			uyeService.uyeGuncelle(uye);

			cevap.setSuccess(true);
			cevap.setMesaj("Kayit basariyla tamamlandi.");
		}
		return uye.getUyeID();
	}

	@POST
	@Path("/uyeSaglikBilgisiKaydet")
	@Produces("application/json; charset=utf-8")
	@Consumes("application/json; charset=utf-8")
	public void uyeSaglikBilgisiKaydet(UyeSaglikIstek saglikIstek) {
		UyeKimlik uye = yeniUyeService.uyeIdKontrol(saglikIstek.getUyeID());
		UyeSaglik uyeSaglik = new UyeSaglik();

		if (saglikIstek.isAlerji() == true) {
			uyeSaglik.setAlerji(true);
		} else {
			uyeSaglik.setAlerji(false);
		}
		if (saglikIstek.isDiyet() == true) {
			uyeSaglik.setDiyet(true);
		} else {
			uyeSaglik.setDiyet(false);
		}

		if (saglikIstek.isHastalik() == true) {
			uyeSaglik.setHastalik(true);
		} else {
			uyeSaglik.setHastalik(false);
		}

		uye.setUyeSaglik(uyeSaglik);

		Hastalik hastalik = new Hastalik();

		for (int i = 0; i < saglikIstek.getHastalikBilgisi().size(); i++) {
			hastalik = new Hastalik();
			hastalik.setHastalikDetay(saglikIstek.getHastalikBilgisi().get(i));
			hastalik.setHastalikIsim(saglikIstek.getHastalikBilgisi().get(i));
			hastalik.setIlac(null);
			uye.getHastalik().add(hastalik);
		}

		Alerji alerji = new Alerji();

		for (int i = 0; i < saglikIstek.getAlerjiBilgisi().size(); i++) {
			alerji = new Alerji();
			alerji.setAlerjiDetay(saglikIstek.getAlerjiBilgisi().get(i));
			alerji.setAlerjiIsim(saglikIstek.getAlerjiBilgisi().get(i));
			alerji.setIlac(null);
			uye.getAlerji().add(alerji);
		}

		uyeService.uyeGuncelle(uye);
	}

	public double bedenKitleHesapla(double kilo, double boy) {
		double sonuc = kilo / ((boy / 100) * (boy / 100));
		return sonuc;
	}
	
	@POST
	@Path("/fotoDondur")
	@Produces("application/json; charset=utf-8")
	@Consumes("application/json; charset=utf-8")
	public AnasayfaCevap fotoDondur(YeniUyeKaydetIstek istek) {
		AnasayfaCevap cevap = new AnasayfaCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek.getEmail());
		String foto = uye.getFotograf();
		cevap.setFotograf(foto);
		return cevap;
	}

}
