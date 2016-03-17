package com.busra.bitirme.commons.daos.web;

import org.hibernate.Session;
import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.Satici;

public class YeniSaticiSayfasiDao{

	public void yeniSaticiKaydet(Satici satici){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(satici);
		session.getTransaction().commit();
	}
	
}