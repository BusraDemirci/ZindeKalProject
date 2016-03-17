package com.busra.bitirme.web.beans;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.busra.bitirme.commons.daos.Dao;
import com.busra.bitirme.commons.entities.uye.UyeKimlik;

@ManagedBean
@ViewScoped
public class Bean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5379809489889172826L;
	UyeKimlik uye = new UyeKimlik();
	
	public UyeKimlik getUye() {
		return uye;
	}
	public void setUye(UyeKimlik uye) {
		this.uye = uye;
	}
	
	public void save(ActionEvent event){
		Dao dao = new Dao();
		dao.save(uye);
	}
}