package com.busra.bitirme.servis.endpoint;

import java.text.DecimalFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.entities.uye.UyeVucut;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.commons.services.mobil.UyeService;
import com.busra.bitirme.servis.model.cevap.ProfilBilgileriCevap;
import com.busra.bitirme.servis.model.istek.ProfilBilgileriIstek;

@Path("/profil")
public class ProfilBilgileriEndpoint {

	UyeService uyeService = new UyeService();
	UyeGirisService uyeGirisService = new UyeGirisService();

	@POST
	@Path("/profilDondur")
	@Produces("application/json; charset=utf-8")
	@Consumes("application/json; charset=utf-8")
	public ProfilBilgileriCevap profilDondur(ProfilBilgileriIstek istek) {
		String email = istek.getEmail();
		ProfilBilgileriCevap cevap = new ProfilBilgileriCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(email);
		cevap.setYeniTel(uye.getUyeTelefon());
		cevap.setYeniBel(uye.getUyeVucut().getBel());
		cevap.setYeniKalca(uye.getUyeVucut().getKalca());
		cevap.setYeniBoy(uye.getUyeVucut().getBoy());
		cevap.setYeniKilo(uye.getUyeVucut().getKilo());
		cevap.setYeniGogus(uye.getUyeVucut().getGogus());
		return cevap;
	}

	@POST
	@Path("/profilBilgileriDegistir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public ProfilBilgileriCevap profilBilgileriDegistir(ProfilBilgileriIstek profilIstek) {
		DecimalFormat df = new DecimalFormat("#.##");
		ProfilBilgileriCevap cevap = new ProfilBilgileriCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(profilIstek.getEmail());
		UyeVucut vucut = new UyeVucut();
		cevap.setYeniTel(profilIstek.getYeniTel());
		cevap.setYeniBel(profilIstek.getYeniBel());
		cevap.setYeniKalca(profilIstek.getYeniKalca());
		cevap.setYeniBoy(profilIstek.getYeniBoy());
		cevap.setYeniKilo(profilIstek.getYeniKilo());
		cevap.setYeniGogus(profilIstek.getYeniGogus());
		uye.setUyeTelefon(profilIstek.getYeniTel());
		vucut.setIdealVki(profilIstek.getYeniBoy() - 110);
		vucut.setOlcuID(uye.getUyeVucut().getOlcuID());
		double bki = bedenKitleHesapla(profilIstek.getYeniKilo(), profilIstek.getYeniBoy());
		vucut.setBedenKitleIndeksi(Double.parseDouble(df.format(bki)));
		vucut.setBel(profilIstek.getYeniBel());
		vucut.setBoy(profilIstek.getYeniBoy());
		vucut.setGogus(profilIstek.getYeniGogus());
		vucut.setKalca(profilIstek.getYeniKalca());
		vucut.setKilo(profilIstek.getYeniKilo());
		uye.setUyeVucut(vucut);
		uyeService.uyeGuncelle(uye);
		cevap.setMesaj("Güncellendi.");
		cevap.setSuccess(true);

		return cevap;
	}
	
	public double bedenKitleHesapla(double kilo, double boy) {
		double sonuc = kilo / ((boy / 100) * (boy / 100));
		return sonuc;
	}

}
