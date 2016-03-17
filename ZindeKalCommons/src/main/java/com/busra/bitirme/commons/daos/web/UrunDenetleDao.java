package com.busra.bitirme.commons.daos.web;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;

public class UrunDenetleDao {

	@SuppressWarnings("unchecked")
	public ArrayList<UrunOzellik> urunIsmineGoreAra(String urunIsim){
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		criteria.add(Restrictions.like("urunIsim", urunIsim, MatchMode.ANYWHERE));
		return (ArrayList<UrunOzellik>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<UrunOzellik> barkodNumarasýnaGoreAra(String barkodNo){
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunOzellik.class);
		criteria.add(Restrictions.eq("barkodNo", barkodNo));
		return (ArrayList<UrunOzellik>) criteria.list();
	}
	
	public UrunIcerik urunBarkodunaGoreUrunIcerigiGetir(String barkodNo){
		Criteria criteria = HibernateUtil.getSession().createCriteria(UrunIcerik.class);
		criteria.add(Restrictions.eq("barkodNo", barkodNo));
		return (UrunIcerik) criteria.uniqueResult();
	}
}