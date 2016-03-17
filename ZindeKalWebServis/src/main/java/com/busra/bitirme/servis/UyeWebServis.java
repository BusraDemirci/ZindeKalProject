package com.busra.bitirme.servis;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/uye")
public class UyeWebServis {

	// çakma veritabaný ;)
	private static Long ID_SEQUENCE = 0L;
	private static Map<Long, Uye> USER_DB = new HashMap<Long, Uye>();

	static {
		USER_DB.put(newId(), Uye.create("busra", "busra email"));
		USER_DB.put(newId(), Uye.create("ufuk", "ufuk email"));
	}
	
	private static Long newId() {
		ID_SEQUENCE++;
		return ID_SEQUENCE;
	}

	@GET
	@Path("/merhaba/{uyeAdi}")
	@Produces("text/plain; charset=utf-8")
	public String hello(@PathParam("uyeAdi") String uyeAdi) {
		return "Merhaba " + uyeAdi;
	}

	@GET
	@Path("/uyeBilgileri/{id}")
	@Produces("application/json; charset=utf-8")
	public Uye userInfo(@PathParam("id") Long id) {
		return USER_DB.get(id);
	}

	@POST
	@Path("/uyeKaydet")
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String newUser(Uye uye) {
		USER_DB.put(newId(), uye);
		return "Kaydettik bro !";
	}
}
