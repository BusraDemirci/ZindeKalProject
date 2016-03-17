package com.busra.bitirme.servis.endpoint;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.busra.bitirme.commons.entities.bilgiler.FaydaliBilgiler;
import com.busra.bitirme.commons.services.mobil.FaydaliBilgilerService;
import com.busra.bitirme.servis.model.cevap.UyeCevap;

@Path("/faydaliBilgi")
public class FaydaliBilgilerEndPoint {

	FaydaliBilgilerService faydaliBilgilerservice = new FaydaliBilgilerService();

	@GET
	@Path("/FaydaliBilgilerDondur")
	@Produces("application/json; charset=utf-8")
	public ArrayList<FaydaliBilgiler> FaydaliBilgilerDondur() {
		UyeCevap cevap = new UyeCevap();
		ArrayList<FaydaliBilgiler> list = faydaliBilgilerservice.faydaliBilgiler();
		cevap.setSuccess(true);
		cevap.setMesaj("Kayýt baþarýyla tamamlandý.");
		return list;
	}

}
