package com.busra.bitirme.commons.daos.mobil;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;

public class GecmisDao {

	public UrunOzellik barkodnoyaGoreOkutulanUrunOzellikleriniGetir(String barkodNo){
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		criteria.add(Restrictions.eqOrIsNull("barkodNo", barkodNo));
		return (UrunOzellik) criteria.uniqueResult();
	}
	
	public UrunIcerik barkodnoyaGoreOkutulanUrunIceriginiGetir(String barkodNo){
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		criteria.add(Restrictions.eqOrIsNull("barkodNo", barkodNo));
		return (UrunIcerik) criteria.uniqueResult();
	}
}
