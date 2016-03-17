package com.busra.bitirme.commons.daos.mobil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;

public class UyeDao {

	public void uyeGuncelle(UyeKimlik uye) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(uye);
		    transaction.commit();
		  } catch (Exception ex) {
		    transaction.rollback();
		    throw ex;
		  }
		}
	
	
	}