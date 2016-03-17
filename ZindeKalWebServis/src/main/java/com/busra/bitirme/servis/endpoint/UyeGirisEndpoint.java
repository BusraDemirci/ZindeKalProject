package com.busra.bitirme.servis.endpoint;

import javax.ws.rs.Consumes;

//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.servis.model.cevap.AnasayfaCevap;
import com.busra.bitirme.servis.model.cevap.UyeCevap;
import com.busra.bitirme.servis.model.istek.UyeGirisIstek;

@Path("/uyeGiris")
public class UyeGirisEndpoint {

	private UyeGirisService uyeGirisService = new UyeGirisService();

	@POST
	@Path("/uyeGirisKontrol")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public UyeCevap uyeGirisKontrol(UyeGirisIstek uyeGirisIstek) {
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(uyeGirisIstek.getEmail());
		UyeCevap cevap = new UyeCevap();
		if (uye == null) {
			cevap.setMesaj("Mailinizi kontrol ederek tekrar deneyiniz.");
			cevap.setSuccess(false);
		} else {
			String kullaniciGirilenMail = uyeGirisIstek.getEmail();
			String kullaniciGirilenSifre = uyeGirisIstek.getSifre();
			if (kullaniciGirilenMail.equals(uye.getUyeMail())
					&& kullaniciGirilenSifre.equals(uye.getUyeSifre())) {
				cevap.setSuccess(true);
				cevap.setMesaj("Simdi giris yapmayi hakettiniz =)");
			} else {
				cevap.setMesaj("Sifrenizi kontrol ederek tekrar deneyiniz.");
				cevap.setSuccess(false);
			}
		}
		return cevap;
	}

	@POST
	@Path("/uyeKayit")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public UyeCevap uyeKayit(UyeGirisIstek uyeOlmaIstek) {
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(uyeOlmaIstek
				.getEmail());
		UyeCevap cevap = new UyeCevap();
		if (uye != null) {
			cevap.setSuccess(false);
			cevap.setMesaj("Bu mail adresi sistemde zaten kullanilmaktadýr.");
		} else {
			uye = new UyeKimlik();
			uye.setUyeIsim(uyeOlmaIstek.getIsim());
			uye.setUyeSoyisim(uyeOlmaIstek.getSoyisim());
			uye.setUyeCinsiyet(uyeOlmaIstek.getCinsiyet());
			uye.setUyeDogumTarihi(uyeOlmaIstek.getDogumTarihi());
			uye.setUyeMail(uyeOlmaIstek.getEmail());
			uye.setUyeSifre(uyeOlmaIstek.getSifre());
			uye.setUyeTelefon(uyeOlmaIstek.getTelefon());
			uyeGirisService.uyeKayit(uye);
			cevap.setSuccess(true);
			cevap.setMesaj("Kayit basariyla tamamlandi.");
		}
		return cevap;
	}

	@POST
	@Path("/anasayfaDoldur")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public AnasayfaCevap anasayfaDoldur(UyeGirisIstek istek) {
		AnasayfaCevap cevap = new AnasayfaCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek.getEmail());
		cevap.setVki(uye.getUyeVucut().getBedenKitleIndeksi());
		cevap.setIdealVKI(uye.getUyeVucut().getIdealVki());
		return cevap;
	}
}