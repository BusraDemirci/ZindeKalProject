package com.busra.bitirme.commons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static Session session;

	public static Session getSession() {
		if (session == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
			session = sessionFactory.openSession();
		}
			if(session.isConnected()) {
				session.clear();
			}
		return session;
	}

}