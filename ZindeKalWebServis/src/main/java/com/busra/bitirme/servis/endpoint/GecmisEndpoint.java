package com.busra.bitirme.servis.endpoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.gecmis.OkutmaGecmisi;
import com.busra.bitirme.commons.entities.gecmis.TuketimGecmisi;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
//import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.GecmisService;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;
import com.busra.bitirme.commons.services.mobil.UyeService;
import com.busra.bitirme.servis.model.cevap.GecmisCevap;
import com.busra.bitirme.servis.model.istek.GecmisIstek;

@Path("/gecmis")
public class GecmisEndpoint {

	UyeService uyeService = new UyeService();

	UyeGirisService uyeGirisService = new UyeGirisService();

	OkutmaGecmisi okutmaGecmisi = new OkutmaGecmisi();
	
	GecmisService gecmisService = new GecmisService();

	@POST
	@Path("/gunlukOkutmaGecmisiniGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public GecmisCevap gunlukOkutmaGecmisiniGetir(GecmisIstek istek) throws ParseException {
		String email = istek.getEmail();
		GecmisCevap cevap = new GecmisCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(email);
		/*if(uye.getOkutulanUrunler() == null){
			uye.setOkutulanUrunler(new ArrayList<OkutmaGecmisi>());
		}*/
		List<OkutmaGecmisi> tumOkutulanlar = uye.getOkutulanUrunler();
		List<UrunOzellik> gunlukOkutmaGecmisi = new ArrayList<>();
		for(int i=0;i<tumOkutulanlar.size();i++){
			long tarih1 = tumOkutulanlar.get(i).getOkutmaTarihi().getTime();
			long tarih2 = bugunuBul().getTime();
			if(tarih1 == tarih2){
				gunlukOkutmaGecmisi.add(gecmisService.barkodnoyaGoreOkutulanUrunOzellikleriniGetir(tumOkutulanlar.get(i).getBarkodNo()));
			}
		}
		cevap.setGunlukOkutulanUrunler(gunlukOkutmaGecmisi);
		return cevap;
	}
	
	@POST
	@Path("/haftalikOkutmaGecmisiniGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public GecmisCevap haftalikOkutmaGecmisiniGetir(GecmisIstek istek) throws ParseException {
		String email = istek.getEmail();
		GecmisCevap cevap = new GecmisCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(email);
		//uye.setOkutulanUrunler(geciciOkutmaGecmisiListesi);
		if(uye.getOkutulanUrunler() == null){
			uye.setOkutulanUrunler(new ArrayList<OkutmaGecmisi>());
		}
		List<OkutmaGecmisi> tumOkutulanlar = uye.getOkutulanUrunler();
		List<UrunOzellik> haftalikOkutulanlar = new ArrayList<>();
		for(int i=0; i < tumOkutulanlar.size(); i++){
			long tarih1 = tumOkutulanlar.get(i).getOkutmaTarihi().getTime();
			long tarih2 = bugunuBul().getTime();
			if(tarih1 > birHaftaOncesininTarihiniBul().getTime() && tarih1 <= tarih2){
				haftalikOkutulanlar.add(gecmisService.barkodnoyaGoreOkutulanUrunOzellikleriniGetir(tumOkutulanlar.get(i).getBarkodNo()));
			}
		}
		cevap.setHaftalikOkutulanUrunler(haftalikOkutulanlar);
		return cevap;
	}
	
	@POST
	@Path("/gunlukTuketimGecmisiniGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public GecmisCevap gunlukTuketimGecmisiniGetir(GecmisIstek istek) throws ParseException {
		String email = istek.getEmail();
		GecmisCevap cevap = new GecmisCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(email);
		List<TuketimGecmisi> tumTuketilenler = uye.getTuketilenUrunler();
		List<UrunOzellik> gunlukTuketilenler = new ArrayList<>();
		for(int i=0;i<tumTuketilenler.size();i++){
			long tarih1 = tumTuketilenler.get(i).getTuketimTarihi().getTime();
			long tarih2 = bugunuBul().getTime();
			if(tarih1 == tarih2){
				gunlukTuketilenler.add(gecmisService.barkodnoyaGoreOkutulanUrunOzellikleriniGetir(tumTuketilenler.get(i).getBarkodNo()));
			}
		}
		cevap.setGunlukTuketilenler(gunlukTuketilenler);
		return cevap;
	}
	
	@POST
	@Path("/haftalikTuketimGecmisiniGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public GecmisCevap haftalikTuketimGecmisiniGetir(GecmisIstek istek) throws ParseException {
		GecmisCevap cevap = new GecmisCevap();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek.getEmail());
		List<TuketimGecmisi> tumTuketilenler = uye.getTuketilenUrunler();
		List<UrunOzellik> haftalikTuketilenler = new ArrayList<>();
		for(int i=0;i<tumTuketilenler.size();i++){
			long tarih1 = tumTuketilenler.get(i).getTuketimTarihi().getTime();
			long tarih2 = bugunuBul().getTime();
			if(tarih1 > birHaftaOncesininTarihiniBul().getTime() && tarih1 <= tarih2){
				haftalikTuketilenler.add(gecmisService.barkodnoyaGoreOkutulanUrunOzellikleriniGetir(tumTuketilenler.get(i).getBarkodNo()));
			}
		}
		cevap.setHaftalikTuketilenler(haftalikTuketilenler);
		return cevap;
	}
	
	@POST
	@Path("/tuketimGecmisineUrunKaydet")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public void tuketimGecmisineUrunKaydet(GecmisIstek istek) throws ParseException{
		SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = istek.getDate();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(istek.getEmail());
		TuketimGecmisi tuketilenUrun = new TuketimGecmisi();
		tuketilenUrun.setBarkodNo(istek.getBarkodNo());
	
		try {
			Date date = formatter.parse(dateInString);
			tuketilenUrun.setTuketimTarihi(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		uye.getTuketilenUrunler().add(tuketilenUrun);
		uyeService.uyeGuncelle(uye);
	}
	
	public Date bugunuBul() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date bugun = dateFormat.parse(dateFormat.format(new Date()));
		return bugun;
	}
	
	public Date dunuBul() throws ParseException{
		Calendar takvim = Calendar.getInstance();
		takvim.setTime(bugunuBul());
		takvim.add(Calendar.DAY_OF_YEAR, -1);
		Date dun = takvim.getTime();
		return dun;
	}
	
	public Date birHaftaOncesininTarihiniBul() throws ParseException{
		Calendar takvim = Calendar.getInstance();
		takvim.setTime(bugunuBul());
		takvim.add(Calendar.DAY_OF_YEAR, -7);
		Date biHaftaOncesi = takvim.getTime();
		return biHaftaOncesi;
	}
	
	
	
}
