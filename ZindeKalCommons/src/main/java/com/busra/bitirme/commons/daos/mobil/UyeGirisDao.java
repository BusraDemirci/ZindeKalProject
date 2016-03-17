package com.busra.bitirme.commons.daos.mobil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;

public class UyeGirisDao {

	
	public UyeKimlik uyeMaileGoreKontrol(String email){
		Criteria criteria = HibernateUtil.getSession(). createCriteria(UyeKimlik.class);
		criteria.add(Restrictions.eq("uyeMail", email));
		return (UyeKimlik) criteria.uniqueResult();
	}
	
	public void yeniUyeKaydet(UyeKimlik yeniUye) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(yeniUye);
		session.getTransaction().commit();
	}
}
