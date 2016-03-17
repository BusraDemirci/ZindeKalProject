package com.busra.bitirme.commons.daos.mobil;

import java.util.ArrayList;

import org.hibernate.Criteria;

import com.busra.bitirme.commons.HibernateUtil;
import com.busra.bitirme.commons.entities.bilgiler.FaydaliBilgiler;


public class FaydaliBilgilerDao {

	@SuppressWarnings("unchecked")
	public ArrayList<FaydaliBilgiler> faydalibilgileriGetir() {
		Criteria criteria = HibernateUtil.getSession().createCriteria(FaydaliBilgiler.class);	 
		return (ArrayList<FaydaliBilgiler>) criteria.list();
	}
	
}
