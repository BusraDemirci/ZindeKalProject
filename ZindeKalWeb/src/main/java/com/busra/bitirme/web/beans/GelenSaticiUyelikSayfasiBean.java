package com.busra.bitirme.web.beans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import com.busra.bitirme.commons.entities.Satici;
import com.busra.bitirme.commons.services.web.GelenSaticiUyelikSayfasiService;

@ManagedBean
@ViewScoped
public class GelenSaticiUyelikSayfasiBean {
	
	private ArrayList<Satici> onayBekleyenSaticilar = new ArrayList<Satici>();
	
	private int istekSayisi = 0;
	
	public GelenSaticiUyelikSayfasiService istekService = new GelenSaticiUyelikSayfasiService();
	
	@ManagedProperty("#{girisSayfasiBackingBean}")
	private GirisSayfasiBackingBean girisSayfasiBackingBean;
	
	public int getIstekSayisi() {
		return istekSayisi;
	}

	public void setIstekSayisi(int istekSayisi) {
		this.istekSayisi = istekSayisi;
	}
	
	public ArrayList<Satici> getOnayBekleyenSaticilar() {
		return onayBekleyenSaticilar;
	}

	public void setOnayBekleyenSaticilar(ArrayList<Satici> onayBekleyenSaticilar) {
		this.onayBekleyenSaticilar = onayBekleyenSaticilar;
	}
	
	
	@PostConstruct public void saticiIstekSayisiniBul(ComponentSystemEvent event){//gelen satýcý isteklerinin sayýsýný bulur
		setIstekSayisi(istekService.gelenSaticiUyelikIstekleriniBul().size());
		girisSayfasiBackingBean.setYeniUyelikIstekSayisi(getIstekSayisi());
	}
	
	
	
	public void gelenSaticiUyelikIstekleriniBul(ActionEvent event){
		setOnayBekleyenSaticilar(istekService.gelenSaticiUyelikIstekleriniBul());
	}
	
	public void istekSayisiniBirAzalt(){
		setIstekSayisi(getIstekSayisi() - 1);
		girisSayfasiBackingBean.setYeniUyelikIstekSayisi(getIstekSayisi());
	}
	
	public void saticiyiOnayla(Satici onaylanacakSatici){
		onaylanacakSatici.setOnayDurumu("1");
		onaylanacakSatici.setIsSatici("1");
		onaylanacakSatici.setIsAdmin("0");
		saticiIstekSayisiniBul(null);
		istekSayisiniBirAzalt();		
		istekService.onaylananSaticiyiKaydet(onaylanacakSatici);
		onayBekleyenSaticilar.remove(onaylanacakSatici);
		//FacesContext.getCurrentInstance().getExternalContext().redirect("SaticiUyelikIstekleriSayfasi.xhtml");
		//sayfayý refresh ediyo
		FacesContext.getCurrentInstance().addMessage("formid:onaylink", commandLinkMesajUret(true));
	}
	
	public void saticiyiReddet(Satici reddedilenSatici){
		saticiIstekSayisiniBul(null);
		istekSayisiniBirAzalt();
		istekService.saticiReddetveSil(reddedilenSatici);
		onayBekleyenSaticilar.remove(reddedilenSatici);
		//FacesContext.getCurrentInstance().getExternalContext().redirect("SaticiUyelikIstekleriSayfasi.xhtml");		
		FacesContext.getCurrentInstance().addMessage("formid:reddlink", commandLinkMesajUret(false));
	}
	
	public FacesMessage commandLinkMesajUret(boolean flag){
		FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        if(flag){
        	message.setSummary("Satici Onaylandi");
            message.setDetail("Satici Onaylandi");
        }
        else{
        	message.setSummary("Satici Reddedildi");
            message.setDetail("Satici Reddedildi");
        }
        return message;
	}

	public void setGirisSayfasiBackingBean(GirisSayfasiBackingBean girisSayfasiBackingBean) {
		this.girisSayfasiBackingBean = girisSayfasiBackingBean;
	}
}
