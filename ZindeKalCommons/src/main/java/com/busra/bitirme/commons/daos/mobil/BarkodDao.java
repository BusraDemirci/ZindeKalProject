package com.busra.bitirme.commons.daos.mobil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;

public class BarkodDao {

	public UrunOzellik barkodNoIleUrunArama(String barkodNo) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(
				UrunOzellik.class);
		criteria.add(Restrictions.eq("barkodNo", barkodNo));
		return (UrunOzellik) criteria.uniqueResult();
	}

	public void urunGuncelle(UrunOzellik urun) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(urun);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}
}
