package com.busra.bitirme.web.beans;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

import com.busra.bitirme.commons.entities.YorumSikayetOneri;
import com.busra.bitirme.commons.services.web.YorumSikayetService;

@ManagedBean
@ViewScoped
public class YorumSikayetOneriDenetlemeBean {
	
	public YorumSikayetService yorumSikayetServis = new YorumSikayetService();
	
	private ArrayList<YorumSikayetOneri> yorumList = new ArrayList<YorumSikayetOneri>();

	private ArrayList<YorumSikayetOneri> sikayetList = new ArrayList<YorumSikayetOneri>();
	
	private ArrayList<YorumSikayetOneri> oneriList = new ArrayList<YorumSikayetOneri>();
	
	@ManagedProperty("#{girisSayfasiBackingBean}")
	private GirisSayfasiBackingBean girisSayfasiBackingBean;
	
	public ArrayList<YorumSikayetOneri> getYorumList() {
		return yorumList;
	}

	public void setYorumList(ArrayList<YorumSikayetOneri> yorumList) {
		this.yorumList = yorumList;
	}

	public ArrayList<YorumSikayetOneri> getSikayetList() {
		return sikayetList;
	}

	public void setSikayetList(ArrayList<YorumSikayetOneri> sikayetList) {
		this.sikayetList = sikayetList;
	}

	public ArrayList<YorumSikayetOneri> getOneriList() {
		return oneriList;
	}

	public void setOneriList(ArrayList<YorumSikayetOneri> oneriList) {
		this.oneriList = oneriList;
	}
	
	@PostConstruct public void yorumSikayetOneriListeleriniDoldur(ComponentSystemEvent event){
		setYorumList(yorumSikayetServis.yorumlariBul());
		setSikayetList(yorumSikayetServis.sikayetleriBul());
		setOneriList(yorumSikayetServis.onerileriBul());
		girisSayfasiBackingBean.setYeniYorumSikayetOneriSayisi(yorumList.size() + sikayetList.size() + oneriList.size());
	}
	
	public void yorumuOnayla(YorumSikayetOneri yorum) throws IOException{
		yorum.setIsGoruldu("1");
		yorumList.remove(yorum);
		girisSayfasiBackingBean.setYeniYorumSikayetOneriSayisi(girisSayfasiBackingBean.getYeniYorumSikayetOneriSayisi() - 1);
		yorumSikayetServis.yorumuOnayla(yorum);
	}
	
	public void sikayetiOnayla(YorumSikayetOneri sikayet) throws IOException{
		sikayet.setIsGoruldu("1");
		sikayetList.remove(sikayet);
		girisSayfasiBackingBean.setYeniYorumSikayetOneriSayisi(yorumList.size() + sikayetList.size() + oneriList.size());
		yorumSikayetServis.sikayetiOnayla(sikayet);
	}
	
	public void oneriyiOnayla(YorumSikayetOneri oneri) throws IOException{
		oneri.setIsGoruldu("1");
		oneriList.remove(oneri);
		girisSayfasiBackingBean.setYeniYorumSikayetOneriSayisi(yorumList.size() + sikayetList.size() + oneriList.size());
		yorumSikayetServis.oneriyiOnayla(oneri);
	}

	public void setGirisSayfasiBackingBean(GirisSayfasiBackingBean girisSayfasiBackingBean) {
		this.girisSayfasiBackingBean = girisSayfasiBackingBean;
	}
	
}
