package com.busra.bitirme.servis.endpoint;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.bilgiler.SizeOzel;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.services.mobil.SizeOzelService;
import com.busra.bitirme.commons.services.mobil.UyeGirisService;

import com.busra.bitirme.servis.model.istek.*;

@Path("/sizeOzel")
public class SizeOzelEndpoint {

	SizeOzelService sizeOzelService = new SizeOzelService();

	UyeGirisService uyeGirisService = new UyeGirisService();

	@POST
	@Path("kullaniciyaOzelTavsiyeGetir")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public ArrayList<String> kullaniciyaOzelTavsiyeGetir(UyeIstek istek) {
		String kullaniciMail = istek.getEmail();
		int genelCount = 0;
		ArrayList<ArrayList<SizeOzel>> tumListeler = new ArrayList<>();
		ArrayList<String> tumBilgiler = new ArrayList<String>();
		UyeKimlik uye = uyeGirisService.uyeMaileGoreKontrol(kullaniciMail);
		uye.setHastalik(uye.getHastalik());

		if (uye.getUyeSaglik().isDiyet()) {
			tumListeler.add(genelCount, sizeOzelService.diyetleIlgiliBilgilerGetir());
			genelCount++;
		}
		if (uye.getUyeSaglik().isHastalik()) {
			for (int i = 0; i < uye.getHastalik().size(); i++) {
				tumListeler.add(genelCount, sizeOzelService.hastaliklarlaIlgiliBilgilerGetir(uye.getHastalik().get(i).getHastalikIsim()));
				genelCount++;
			}
		}

		/*if (uye.getUyeSaglik().isAlerji()) {
			for (int i = 0; i < uye.getAlerji().size(); i++) {
				tumBilgiler.add(genelCount,	sizeOzelService.alerjilerleIlgiliBilgilerGetir(uye.getAlerji().get(i).getAlerjiIsim()));
				genelCount++;
			}
		}*/

		for (int i = 0; i < tumListeler.size(); i++) {
			for (int j = 0; j < tumListeler.get(i).size(); j++) {
				tumBilgiler.add(tumListeler.get(i).get(j).getBilgiMetni());
			}
		}
		return tumBilgiler;
	}
}
