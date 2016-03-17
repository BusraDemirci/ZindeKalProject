package com.busra.bitirme.commons.daos.mobil;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.bilgiler.SizeOzel;

public class SizeOzelDao {
	
	@SuppressWarnings("unchecked")
	public ArrayList<SizeOzel> diyetleIlgiliBilgilerGetir(){
		Criteria criteria = HibernateUtil.getSession(). createCriteria(SizeOzel.class);
		criteria.add(Restrictions.like("bilgiKonusu", "diyet", MatchMode.ANYWHERE));
		return (ArrayList<SizeOzel>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<SizeOzel> hastaliklarlaIlgiliBilgilerGetir(String hastalik){
		Criteria criteria = HibernateUtil.getSession(). createCriteria(SizeOzel.class);
		criteria.add(Restrictions.like("bilgiKonusu", hastalik, MatchMode.ANYWHERE));
		return (ArrayList<SizeOzel>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<SizeOzel> alerjilerleIlgiliBilgilerGetir(String alerji){
		Criteria criteria = HibernateUtil.getSession(). createCriteria(SizeOzel.class);
		criteria.add(Restrictions.like("bilgiKonusu", alerji, MatchMode.ANYWHERE));
		return (ArrayList<SizeOzel>) criteria.list();
	}
}
