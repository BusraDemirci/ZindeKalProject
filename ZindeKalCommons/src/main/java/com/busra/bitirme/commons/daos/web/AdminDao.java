package com.busra.bitirme.commons.daos.web;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.Satici;

public class AdminDao {

	public Satici adminiBul(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Satici.class);
		criteria.add(Restrictions.eq("isAdmin", "1"));
		return (Satici) criteria.uniqueResult();
	}
	
	public void adminIdsiniBulVeAdminBilgileriniGuncelle(Satici admin){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		//admin.setSaticiID(admin.getSaticiID());
		//session.delete(adminiBul());		
		session.persist(admin);
		session.getTransaction().commit();
	}
	
}