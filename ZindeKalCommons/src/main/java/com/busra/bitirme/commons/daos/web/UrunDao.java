package com.busra.bitirme.commons.daos.web;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.Tavsiye;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.entities.urun.UrunIcerik;

public class UrunDao {

	@SuppressWarnings("unchecked")
	public ArrayList<UrunOzellik> urunIsmiIleOzellikDondur(String urunIsim) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		criteria.add(Restrictions.like("urunIsim", urunIsim, MatchMode.ANYWHERE));
		return (ArrayList<UrunOzellik>) criteria.list();
	}

	public UrunIcerik barkodNoyaGoreIcerikdondur(String barkodNo) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunIcerik.class);
		criteria.add(Restrictions.eq("barkodNo", barkodNo));
		return (UrunIcerik) criteria.uniqueResult();
	}

	public UrunOzellik barkodNoIleUrunArama(String barkodNo) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		criteria.add(Restrictions.eq("barkodNo", barkodNo));
		return (UrunOzellik) criteria.uniqueResult();
	}

	public void urunEkle(UrunOzellik urunOzellik) {
		Session session = HibernateUtil.getSession();
		if (HibernateUtil.getSession().isConnected()) {
			session.clear();
		}
		session.beginTransaction();
		session.save(urunOzellik);
		session.getTransaction().commit();

	}

	public boolean urunSil(ArrayList<UrunOzellik> silinecekUrunOzellikleri) {
		for (int i = 0; i < silinecekUrunOzellikleri.size(); i++) {
			Session session = HibernateUtil.getSession();
			if (HibernateUtil.getSession().isConnected()) {
				session.clear();
			}
			session.beginTransaction();
			UrunOzellik urun = silinecekUrunOzellikleri.get(i);
			session.delete(urun);
			session.getTransaction().commit();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UrunOzellik> selectedUrunleriBul() {
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		criteria.add(Restrictions.eq("selected", Boolean.TRUE));
		return (ArrayList<UrunOzellik>) criteria.list();
	}

	public void urunGuncelle(ArrayList<UrunOzellik> guncelUrunOzellikleri, ArrayList<UrunIcerik> guncelUrunIcerikleri) {
		Session session = HibernateUtil.getSession();
		if (HibernateUtil.getSession().isConnected()) {
			session.clear();
		}
		session.beginTransaction();
		session.saveOrUpdate(guncelUrunOzellikleri.get(0));
		// session.saveOrUpdate(guncelUrunIcerikleri.get(0));
		session.getTransaction().commit();
	}

	public void urunGuncelle(UrunOzellik guncelUrun) {
		Session session = HibernateUtil.getSession();
		if (HibernateUtil.getSession().isConnected()) {

			session.clear();
		}
		session.beginTransaction();
		session.merge(guncelUrun);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UrunOzellik> enCokOkutulanveTuketilenUrunuBul() {
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		return (ArrayList<UrunOzellik>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Tavsiye> tavsiyeTablosunuDondur(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Tavsiye.class);
		return (ArrayList<Tavsiye>) criteria.list();
	}
}
