package com.busra.bitirme.servis;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

public class ZindeKalWebServis extends Application {

	@Override
	public final Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(JacksonFeature.class);
		return set;
	}

}
