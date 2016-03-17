package com.busra.bitirme.commons.daos;

import org.hibernate.Session;
import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;

public class Dao{


	public void save(UyeKimlik uye){		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(uye);
		session.getTransaction().commit();
	}
}
