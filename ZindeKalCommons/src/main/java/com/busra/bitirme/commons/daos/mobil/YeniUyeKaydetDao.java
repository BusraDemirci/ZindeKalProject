package com.busra.bitirme.commons.daos.mobil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.alerji.Alerji;
import com.busra.bitirme.commons.entities.hastalik.Hastalik;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;
import com.busra.bitirme.commons.entities.uye.UyeSaglik;
import com.busra.bitirme.commons.entities.uye.UyeVucut;

public class YeniUyeKaydetDao {
	
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
	public void yeniUyeVucutBilgisiKaydet(UyeVucut yeniUyeVucutBilgisi) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(yeniUyeVucutBilgisi);
		session.getTransaction().commit();
	}
	
	public UyeKimlik uyeIdKontrol(long uyeId){
		Criteria criteria = HibernateUtil.getSession(). createCriteria(UyeKimlik.class);
		criteria.add(Restrictions.eq("uyeID", uyeId));
		return (UyeKimlik) criteria.uniqueResult();
	}
	public void uyeGuncelle(UyeKimlik uye) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(uye);
		session.getTransaction().commit();
	}
	
	public void yeniUyeHastalikBilgisiKaydet(Hastalik hasta) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(hasta);
		session.getTransaction().commit();
	}
	public void yeniUyeSaglikBilgisiKaydet(UyeSaglik saglikDurumu) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(saglikDurumu);
		session.getTransaction().commit();
	}
	public void yeniUyeAlerjiBilgisiKaydet(Alerji alerji) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(alerji);
		session.getTransaction().commit();
	}
}
