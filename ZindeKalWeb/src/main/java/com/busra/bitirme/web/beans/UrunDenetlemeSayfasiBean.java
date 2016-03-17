package com.busra.bitirme.web.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.services.web.UrunDenetleService;

@ManagedBean
@ViewScoped
public class UrunDenetlemeSayfasiBean {
	
	private ArrayList<UrunOzellik> urunOzellikList = new ArrayList<UrunOzellik>();

	public UrunDenetleService urunService = new UrunDenetleService();
	
	private UrunIcerik urunIcerik = new UrunIcerik();

	private Long urunId;

	private String barkodNo;
	
	private String urunIsim;
	

	public UrunIcerik getUrunIcerik() {
		return urunIcerik;
	}

	public void setUrunIcerik(UrunIcerik urunIcerik) {
		this.urunIcerik = urunIcerik;
	}
	
	public String getBarkodNo() {
		return barkodNo;
	}
	
	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}

	public String getUrunIsim() {
		return urunIsim;
	}
	public void setUrunIsim(String urunIsim) {
		this.urunIsim = urunIsim;
	}

	public ArrayList<UrunOzellik> getUrunList() {
		return urunOzellikList;
	}

	public void setUrunOzellikList(ArrayList<UrunOzellik> urunOzellikList) {
		this.urunOzellikList = urunOzellikList;
	}

	public ArrayList<UrunOzellik> getUrunOzellikList() {
		return urunOzellikList;
	}
	
	public Long getUrunId() {
		return urunId;
	}

	public void setUrunId(Long urunId) {
		this.urunId = urunId;
	}
	
	public void facesMesajOlustur(String mesaj) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(mesaj);
		facesContext.addMessage("panel", facesMessage);
	}
	
	public void barkodNoYaDaIsmeGoreUrunAra() throws IOException {
		if(getBarkodNo() == ""){
			if(getUrunIsim() != ""){
				setUrunOzellikList(urunService.urunIsmineGoreAra(getUrunIsim()));
			}
		}
		else if(getUrunIsim() == ""){
			if(getBarkodNo() != ""){
				setUrunOzellikList(urunService.barkodNumarasýnaGoreAra(getBarkodNo()));
			}
		}
		else{
			FacesContext.getCurrentInstance().getExternalContext().redirect("YeniUrunEklemeSayfasi.xhtml");
			//facesMesajOlustur("Sadece bir özellik ile arama yapabilirsiniz.");
		}		
	}
	
	

	public void urunIdsineGoreUrunIcerigiGetir() {
		setUrunIcerik(urunService.urunBarkodunaGoreUrunIcerigiGetir(urunBarkodEldeEt()));
	}

	public String urunBarkodEldeEt() {
		FacesContext fc = FacesContext.getCurrentInstance();
		setBarkodNo(getUrunBarkod(fc));
		return getBarkodNo();
	}

	public String getUrunBarkod(FacesContext fc) {
		Map<String, String> parametre = fc.getExternalContext().getRequestParameterMap();
		return parametre.get("urunBarkod");
	}
}
