package com.busra.bitirme.servis.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.YorumSikayetOneri;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.commons.services.mobil.UyeService;
import com.busra.bitirme.servis.model.istek.YorumSikayetOneriIstek;

@Path("/yorumSikayetOneri")
public class YorumSikayetOneriEndpoint {

	UyeService uyeYorumService = new UyeService();
	UyeGirisService uyeGirisService = new UyeGirisService();

	@POST
	@Path("/YorumKaydet")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public void YorumKaydet(YorumSikayetOneriIstek yorumIstek) {
		YorumSikayetOneri yorum = new YorumSikayetOneri();
		UyeKimlik uye = new UyeKimlik();
		uye = uyeGirisService.uyeMaileGoreKontrol(yorumIstek.getEmail());
		yorum.setIsGoruldu("0");
		yorum.setKonu(yorumIstek.getKonu());
		yorum.setMetin(yorumIstek.getMetin());
		yorum.setTuru("yorum");
		uye.getYorumSikayetOneri().add(yorum);
		uyeYorumService.uyeGuncelle(uye);
	}

	@POST
	@Path("/SikayetKaydet")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public void SikayetKaydet(YorumSikayetOneriIstek sikayetIstek) {
		YorumSikayetOneri sikayet = new YorumSikayetOneri();
		UyeKimlik uye = new UyeKimlik();
		uye = uyeGirisService.uyeMaileGoreKontrol(sikayetIstek.getEmail());
		sikayet.setIsGoruldu("0");
		sikayet.setKonu(sikayetIstek.getKonu());
		sikayet.setMetin(sikayetIstek.getMetin());
		sikayet.setTuru("sikayet");
		uye.getYorumSikayetOneri().add(sikayet);
		uyeYorumService.uyeGuncelle(uye);
	}

	@POST
	@Path("/OneriKaydet")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public void OneriKaydet(YorumSikayetOneriIstek oneriIstek) {
		YorumSikayetOneri oneri = new YorumSikayetOneri();
		UyeKimlik uye = new UyeKimlik();
		uye = uyeGirisService.uyeMaileGoreKontrol(oneriIstek.getEmail());
		oneri.setIsGoruldu("0");
		oneri.setKonu(oneriIstek.getKonu());
		oneri.setMetin(oneriIstek.getMetin());
		oneri.setTuru("oneri");
		uye.getYorumSikayetOneri().add(oneri);
		uyeYorumService.uyeGuncelle(uye);
	}
}
