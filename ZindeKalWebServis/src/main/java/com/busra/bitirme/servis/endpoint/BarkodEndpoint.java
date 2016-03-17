package com.busra.bitirme.servis.endpoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.gecmis.OkutmaGecmisi;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.BarkodService;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.commons.services.mobil.UyeService;
import com.busra.bitirme.servis.model.cevap.BarkodCevap;
import com.busra.bitirme.servis.model.istek.BarkodIstek;

@Path("/barkod")
public class BarkodEndpoint {

	BarkodService urunService = new BarkodService();

	UyeGirisService uyeGirisService = new UyeGirisService();

	UyeService uyeService = new UyeService();

	@POST
	@Path("/barkodOkut")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public BarkodCevap barkodOkut(BarkodIstek istek) {
		OkutmaGecmisi okutulanUrun = new OkutmaGecmisi();
		BarkodCevap cevap = new BarkodCevap();
		UrunOzellik urun = new UrunOzellik();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek.getEmail());
		ArrayList<OkutmaGecmisi> okutmaGecmisi = new ArrayList<>();
		okutulanUrun.setBarkodNo(istek.getBarkodNo());
		try {
			okutulanUrun.setOkutmaTarihi(bugunuBul());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		okutulanUrun.setSatinAlmaDurumu(false);
		okutmaGecmisi.add(okutulanUrun);
		/*
		 * if(uye.getOkutulanUrunler() == null){ //uye.setOkutulanUrunler(new
		 * ArrayList<OkutmaGecmisi>()); //uye.setOkutulanUrunler(okutmaGecmisi);
		 * 
		 * }
		 */
		uye.getOkutulanUrunler().add(okutulanUrun);
		uyeService.uyeGuncelle(uye);
		urun = urunService.barkodNoIleUrunArama(istek.getBarkodNo());
		urun.setOkutmaSayaci(urun.getOkutmaSayaci() + 1);
		urunService.urunGuncelle(urun);
		cevap.setIcerik(urun.getIcerik());
		cevap.setVitamin(urun.getVitamin());
		return cevap;
	}

	public Date bugunuBul() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date bugun = dateFormat.parse(dateFormat.format(new Date()));
		return bugun;
	}

	public Date dunuBul() throws ParseException {
		Calendar takvim = Calendar.getInstance();
		takvim.setTime(bugunuBul());
		takvim.add(Calendar.DAY_OF_YEAR, -1);
		Date dun = takvim.getTime();
		return dun;
	}

	public Date birHaftaOncesininTarihiniBul() throws ParseException {
		Calendar takvim = Calendar.getInstance();
		takvim.setTime(bugunuBul());
		takvim.add(Calendar.DAY_OF_YEAR, -7);
		Date biHaftaOncesi = takvim.getTime();
		return biHaftaOncesi;
	}
}
