package com.busra.bitirme.commons.daos.web;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.Satici;

public class SaticiDao {
	
	public Satici saticiBul(String email){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Satici.class);
		criteria.add(Restrictions.eq("saticiMail", email));
		return (Satici) criteria.uniqueResult();
	}
	
	public void saticiyiBulVeBilgileriniGuncelle(Satici satici){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		//admin.setSaticiID(admin.getSaticiID());
		//session.delete(adminiBul());		
		session.merge(satici);
		session.getTransaction().commit();
	}
}
