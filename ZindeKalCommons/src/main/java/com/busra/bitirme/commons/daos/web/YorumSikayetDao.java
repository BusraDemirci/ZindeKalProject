package com.busra.bitirme.commons.daos.web;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.YorumSikayetOneri;

public class YorumSikayetDao {

	
	@SuppressWarnings("unchecked")
	public ArrayList<YorumSikayetOneri> yorumlariBul(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(YorumSikayetOneri.class);
		Criterion restriction1 = Restrictions.like("turu", "yorum",MatchMode.ANYWHERE);
		Criterion restriction2 = Restrictions.eq("isGoruldu", "0");
		criteria.add(Restrictions.and(restriction1,restriction2));
		return (ArrayList<YorumSikayetOneri>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<YorumSikayetOneri> sikayetleriBul(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(YorumSikayetOneri.class);
		Criterion restriction1 = Restrictions.like("turu", "sikayet",MatchMode.ANYWHERE);
		Criterion restriction2 = Restrictions.eq("isGoruldu", "0");
		criteria.add(Restrictions.and(restriction1,restriction2));
		return (ArrayList<YorumSikayetOneri>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<YorumSikayetOneri> onerileriBul(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(YorumSikayetOneri.class);
		Criterion restriction1 = Restrictions.like("turu", "oneri",MatchMode.ANYWHERE);
		Criterion restriction2 = Restrictions.eq("isGoruldu", "0");
		criteria.add(Restrictions.and(restriction1,restriction2));
		return (ArrayList<YorumSikayetOneri>) criteria.list();
	}
	
	public void yorumuOnayla(YorumSikayetOneri yorum){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.merge(yorum);
		session.getTransaction().commit();
	}
	
	public void sikayetiOnayla(YorumSikayetOneri sikayet){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.merge(sikayet);
		session.getTransaction().commit();
	}
	
	public void oneriyiOnayla(YorumSikayetOneri oneri){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.merge(oneri);
		session.getTransaction().commit();
	}
}
