package com.busra.bitirme.commons.daos.web;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.Satici;

public class GirisSayfasiDao{

	public Satici mailAdresineGoreBul(String mail) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(Satici.class);
		criteria.add(Restrictions.eq("saticiMail", mail));
		return (Satici) criteria.uniqueResult();
	}
}
