package com.busra.bitirme.commons.daos.web;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.Satici;

public class GelenSaticiUyelikSayfasiDao {

	@SuppressWarnings("unchecked")
	public ArrayList<Satici> gelenSaticiUyelikIstekleriniBul() {
		Criteria criteria = HibernateUtil.getSession().createCriteria(Satici.class);
		criteria.add(Restrictions.eq("onayDurumu", "0"));
		return (ArrayList<Satici>) criteria.list();
	}
	
	public void onaylananSaticiyiKaydet(Satici onaylanacakSatici) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(onaylanacakSatici);
		session.getTransaction().commit();
	}

	public void saticiReddetveSil(Satici reddedilenSatici) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(reddedilenSatici);
		session.getTransaction().commit();
	}
}