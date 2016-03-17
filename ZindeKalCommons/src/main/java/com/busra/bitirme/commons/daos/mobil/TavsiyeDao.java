package com.busra.bitirme.commons.daos.mobil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.Tavsiye;
import com.busra.bitirme.commons.entities.uye.GunlukIhtiyac;
import com.busra.bitirme.commons.entities.uye.GunlukVitamin;

public class TavsiyeDao {
	
	Long id = new Long(1);
	
	public GunlukVitamin gunlukVitaminIhtiyaciniGetir(){
		Criteria criteria = HibernateUtil.getSession(). createCriteria(GunlukVitamin.class);
		criteria.add(Restrictions.like("gunlukID", id));
		return (GunlukVitamin) criteria.uniqueResult();
	}
	
	public GunlukIhtiyac gunlukBesinIhtiyaciniGetir(){
		Criteria criteria = HibernateUtil.getSession(). createCriteria(GunlukIhtiyac.class);
		criteria.add(Restrictions.like("ihtiyacID", id));
		return (GunlukIhtiyac) criteria.uniqueResult();
	}
	
	public void tavsiyeKaydet(Tavsiye tavsiye) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(tavsiye);
		session.getTransaction().commit();
	}

}
