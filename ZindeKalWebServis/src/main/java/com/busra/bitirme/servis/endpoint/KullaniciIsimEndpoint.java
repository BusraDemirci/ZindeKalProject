package com.busra.bitirme.servis.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.servis.model.cevap.KullaniciIsimCevap;
import com.busra.bitirme.servis.model.istek.KullaniciIsimIstek;

@Path("/isim")
public class KullaniciIsimEndpoint {

	UyeGirisService uyeGirisService = new UyeGirisService();
	
	@POST
	@Path("/isimDondur")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public KullaniciIsimCevap isimDondur(KullaniciIsimIstek istek) {
		String email = istek.getKullaniciMail();
		KullaniciIsimCevap cevap = new KullaniciIsimCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(email);
		cevap.setIsim(uye.getUyeIsim());
		cevap.setSoyisim(uye.getUyeSoyisim());
		return cevap;
	}
}
