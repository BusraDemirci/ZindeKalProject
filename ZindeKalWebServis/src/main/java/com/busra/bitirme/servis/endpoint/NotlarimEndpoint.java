package com.busra.bitirme.servis.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.Notlar;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.commons.services.mobil.UyeService;
import com.busra.bitirme.servis.model.cevap.NotlarimCevap;
import com.busra.bitirme.servis.model.istek.NotlarimIstek;

@Path("/notlar")
public class NotlarimEndpoint {

	UyeService uyeService = new UyeService();

	UyeGirisService uyeGirisService = new UyeGirisService();

	@POST
	@Path("/yeniNotKaydet")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Notlar yeniNotKaydet(NotlarimIstek notIstek) {
		String email = notIstek.getKullaniciMail();
		Notlar yeniNot = new Notlar();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(email);
		yeniNot.setNotMetni(notIstek.getNot());
		uye.getNotlar().add(yeniNot);
		uyeService.uyeGuncelle(uye);
		return yeniNot;
	}

	@GET
	@Path("/notlarimiDondur")
	@Produces("application/json; charset=utf-8")
	public NotlarimCevap notlarimiDondur(NotlarimIstek notIstek) {
		NotlarimCevap cevap = new NotlarimCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(notIstek.getKullaniciMail());
		cevap.setNotlar(uye.getNotlar());
		return cevap;
	}
}
