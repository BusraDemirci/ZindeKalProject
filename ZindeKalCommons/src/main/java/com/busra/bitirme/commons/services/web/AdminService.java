package com.busra.bitirme.commons.services.web;

import com.busra.bitirme.commons.daos.web.AdminDao;
import com.busra.bitirme.commons.entities.Satici;

public class AdminService {

	AdminDao adminDao = new AdminDao();
	Satici admin = new Satici();
	
	public Satici adminBilgileriniGetir(){
		admin = adminDao.adminiBul();
		return getAdmin();
	}
	
	public void adminiBulveGuncelle(Satici admin){
		adminDao.adminIdsiniBulVeAdminBilgileriniGuncelle(admin);
	}
	
	public Satici getAdmin() {
		return admin;
	}

	public void setAdmin(Satici admin) {
		this.admin = admin;
	}
}
