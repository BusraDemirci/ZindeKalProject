package com.busra.bitirme.servis.model.istek;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UyeSaglikIstek {
private ArrayList<String> alerjiBilgisi;
private ArrayList<String> hastalikBilgisi;
private long uyeID;
private boolean diyet;
public ArrayList<String> getAlerjiBilgisi() {
	return alerjiBilgisi;
}

public void setAlerjiBilgisi(ArrayList<String> alerjiBilgisi) {
	this.alerjiBilgisi = alerjiBilgisi;
}

private boolean hastalik;
private boolean alerji;

public ArrayList<String> getHastalikBilgisi() {
	return hastalikBilgisi;
}

public void setHastalikBilgisi(ArrayList<String> hastalikBilgisi) {
	this.hastalikBilgisi = hastalikBilgisi;
}

public long getUyeID() {
	return uyeID;
}


public void setUyeID(long uyeID) {
	this.uyeID = uyeID;
}

public boolean isDiyet() {
	return diyet;
}

public void setDiyet(boolean diyet) {
	this.diyet = diyet;
}

public boolean isHastalik() {
	return hastalik;
}

public void setHastalik(boolean hastalik) {
	this.hastalik = hastalik;
}

public boolean isAlerji() {
	return alerji;
}

public void setAlerji(boolean alerji) {
	this.alerji = alerji;
}




	
}
