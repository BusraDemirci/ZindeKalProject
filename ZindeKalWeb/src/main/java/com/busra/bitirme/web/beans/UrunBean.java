package com.busra.bitirme.web.beans;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.busra.bitirme.commons.entities.urun.UrunIcerik;
import com.busra.bitirme.commons.entities.urun.UrunOzellik;
import com.busra.bitirme.commons.entities.urun.UrunVitamin;
import com.busra.bitirme.commons.services.web.UrunService;

@ManagedBean
@ViewScoped
public class UrunBean {

	private ArrayList<UrunOzellik> urunOzellikList = new ArrayList<UrunOzellik>();
	private ArrayList<UrunIcerik> urunIcerikList = new ArrayList<UrunIcerik>();

	private boolean showDataTable = false;
	private ArrayList<UrunOzellik> selectableItems = new ArrayList<UrunOzellik>();

	UrunService urunService = new UrunService();

	private UrunOzellik urunOzellik = new UrunOzellik();
	private UrunIcerik urunIcerik = new UrunIcerik();
	private UrunVitamin urunVitamin = new UrunVitamin();
	
	private double tavsiyeyeUymaOraný;

	// Raporlama için
	private UrunOzellik enCokTuketilen = new UrunOzellik();
	private UrunOzellik enCokOkutulan = new UrunOzellik();

	boolean edit = false;
	private String barkodNo;
	private String urunIsim;
	private int urunSayisi;
	private boolean editable = false;
	private boolean butonaBasildimi = false;

	@PostConstruct
	void initialiseSession() { // cannot create a session after the response has
								// been committed hatasý için gerekli
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	/*
	 * @PostConstruct void uruneSaticiEkle() { UrunOzellik urun =
	 * urunService.barkodNoIleUrunArama("1234"); Satici s = new Satici();
	 * s.setIsAdmin("0"); s.setIsSatici("1"); s.setKurumAdi("Diasa");
	 * s.setKurumKodu("1111"); s.setOnayDurumu("1"); s.setSaticiIsim("Busra");
	 * s.setSaticiKimlikNo("123456789"); s.setSaticiMail("satici@diasa.com");
	 * s.setSaticiSifre("1"); s.setSaticiSoyIsim("Uzun");
	 * s.setSaticiTelefon("05334456677"); urun.getSaticilar().add(s);
	 * urunService.urunGuncelle(urun); }
	 */

	public String urunKaydet() {
			yeniUrunEklemedenOzellikIcerikVitaminDoldur();
			urunService.urunEkle(getUrunOzellik());
			return "YeniUrunEklemeSayfasi.xhtml?faces-redirect=true";
	}
	
	public void urunOzellikIcerikVitaminDoldur(){
		
		getUrunVitamin().setUrunVitaminID(getUrunVitamin().getUrunVitaminID());
		getUrunVitamin().setVitA(getUrunVitamin().getVitA());
		getUrunVitamin().setVitB(getUrunVitamin().getVitB());
		getUrunVitamin().setVitC(getUrunVitamin().getVitC());
		getUrunVitamin().setVitD(getUrunVitamin().getVitD());
		getUrunVitamin().setVitE(getUrunVitamin().getVitE());
		getUrunVitamin().setVitK(getUrunVitamin().getVitK());
		
		
		getUrunIcerik().setBarkodNo(getUrunOzellik().getBarkodNo());
		getUrunIcerik().setIcerikID(getUrunVitamin().getUrunVitaminID());
		getUrunIcerik().setUrunDoymusYag(getUrunIcerik().getUrunDoymusYag());
		getUrunIcerik().setUrunEnerji(getUrunIcerik().getUrunEnerji());
		getUrunIcerik().setUrunKalsiyum(getUrunIcerik().getUrunKalsiyum());
		getUrunIcerik().setUrunKarbonhidrat(getUrunIcerik().getUrunKarbonhidrat());
		getUrunIcerik().setUrunKolestrol(getUrunIcerik().getUrunKolestrol());
		getUrunIcerik().setUrunLif(getUrunIcerik().getUrunLif());
		getUrunIcerik().setUrunProtein(getUrunIcerik().getUrunProtein());
		getUrunIcerik().setUrunSeker(getUrunIcerik().getUrunSeker());
		getUrunIcerik().setUrunTransYag(getUrunIcerik().getUrunTransYag());
		getUrunIcerik().setUrunTuz(getUrunIcerik().getUrunTuz());
		getUrunIcerik().setUrunYag(getUrunIcerik().getUrunYag());
		
		getUrunOzellik().setBarkodNo(getUrunOzellik().getBarkodNo());
		getUrunOzellik().setUrunID(getUrunVitamin().getUrunVitaminID());
		getUrunOzellik().setIcerik(getUrunIcerik());
		getUrunOzellik().setKategori(getUrunOzellik().getKategori());
		getUrunOzellik().setOkutmaSayaci(getUrunOzellik().getOkutmaSayaci());
		getUrunOzellik().setSaticilar(getUrunOzellik().getSaticilar());
		getUrunOzellik().setSkt(getUrunOzellik().getSkt());
		getUrunOzellik().setTuketimSayaci(getUrunOzellik().getTuketimSayaci());
		getUrunOzellik().setUrunIcerik(getUrunOzellik().getUrunIcerik());
		getUrunOzellik().setUrunIsim(getUrunOzellik().getUrunIsim());
		getUrunOzellik().setVitamin(getUrunVitamin());
		
		getUrunOzellikList().set(0, getUrunOzellik());
		getUrunIcerikList().set(0, getUrunIcerik());
		getUrunOzellikList().get(0).setUrunID(getUrunOzellikList().get(0).getUrunID());
		getUrunOzellikList().get(0).setIcerik(getUrunIcerik());
		getUrunIcerikList().set(0, getUrunIcerik());
		getUrunIcerikList().get(0).setIcerikID(getUrunOzellikList().get(0).getIcerik().getIcerikID());
		getUrunIcerikList().get(0).setBarkodNo(getUrunOzellik().getBarkodNo());
		
		
		//urunService.urunGuncelle(getUrunOzellikList(), getUrunIcerikList());
		
		//getUrunOzellik().getIcerik().setUrun(null);
		//getUrunOzellik().getVitamin().setUrun(null);
	}
	
	public void yeniUrunEklemedenOzellikIcerikVitaminDoldur(){
		getUrunVitamin().setVitA(getUrunVitamin().getVitA());
		getUrunVitamin().setVitB(getUrunVitamin().getVitB());
		getUrunVitamin().setVitC(getUrunVitamin().getVitC());
		getUrunVitamin().setVitD(getUrunVitamin().getVitD());
		getUrunVitamin().setVitE(getUrunVitamin().getVitE());
		getUrunVitamin().setVitK(getUrunVitamin().getVitK());
		
		
		getUrunIcerik().setBarkodNo(getUrunOzellik().getBarkodNo());
		getUrunIcerik().setUrunDoymusYag(getUrunIcerik().getUrunDoymusYag());
		getUrunIcerik().setUrunEnerji(getUrunIcerik().getUrunEnerji());
		getUrunIcerik().setUrunKalsiyum(getUrunIcerik().getUrunKalsiyum());
		getUrunIcerik().setUrunKarbonhidrat(getUrunIcerik().getUrunKarbonhidrat());
		getUrunIcerik().setUrunKolestrol(getUrunIcerik().getUrunKolestrol());
		getUrunIcerik().setUrunLif(getUrunIcerik().getUrunLif());
		getUrunIcerik().setUrunProtein(getUrunIcerik().getUrunProtein());
		getUrunIcerik().setUrunSeker(getUrunIcerik().getUrunSeker());
		getUrunIcerik().setUrunTransYag(getUrunIcerik().getUrunTransYag());
		getUrunIcerik().setUrunTuz(getUrunIcerik().getUrunTuz());
		getUrunIcerik().setUrunYag(getUrunIcerik().getUrunYag());
		
		
		getUrunOzellik().setBarkodNo(getUrunOzellik().getBarkodNo());
		getUrunOzellik().setIcerik(getUrunIcerik());
		getUrunOzellik().setKategori(getUrunOzellik().getKategori());
		getUrunOzellik().setOkutmaSayaci(getUrunOzellik().getOkutmaSayaci());
		getUrunOzellik().setSaticilar(getUrunOzellik().getSaticilar());
		getUrunOzellik().setSkt(getUrunOzellik().getSkt());
		getUrunOzellik().setTuketimSayaci(getUrunOzellik().getTuketimSayaci());
		getUrunOzellik().setUrunIcerik(getUrunOzellik().getUrunIcerik());
		getUrunOzellik().setUrunIsim(getUrunOzellik().getUrunIsim());
		getUrunOzellik().setVitamin(getUrunVitamin());
		//getUrunIcerik().setUrun(new UrunOzellik());
		//getUrunVitamin().setUrun(new UrunOzellik());
		
		getUrunOzellik().setIcerik(getUrunIcerik());
		getUrunOzellik().setVitamin(getUrunVitamin());
	}
	
	public void urunListeleriniDoldur() {
		//urunIcerikList.add(urunService.barkodNoyaGoreIcerikdondur(getBarkodNo()));
		// diðer sayfaya ürün barkod nosunu parametre olarak gönder
		getUrunOzellik().setBarkodNo(getUrunOzellikList().get(0).getBarkodNo());
		getUrunOzellik().setKategori(getUrunOzellikList().get(0).getKategori());
		getUrunOzellik().setSkt(getUrunOzellikList().get(0).getSkt());
		getUrunOzellik().setUrunIcerik(getUrunOzellikList().get(0).getUrunIcerik());
		getUrunOzellik().setUrunIsim(getUrunOzellikList().get(0).getUrunIsim());
		getUrunIcerik().setUrunDoymusYag(getUrunIcerikList().get(0).getUrunDoymusYag());
		getUrunIcerik().setUrunEnerji(getUrunIcerikList().get(0).getUrunEnerji());
		getUrunIcerik().setUrunKalsiyum(getUrunIcerikList().get(0).getUrunKalsiyum());
		getUrunIcerik().setUrunKarbonhidrat(getUrunIcerikList().get(0).getUrunKarbonhidrat());
		getUrunIcerik().setUrunKolestrol(getUrunIcerikList().get(0).getUrunKolestrol());
		getUrunIcerik().setUrunLif(getUrunIcerikList().get(0).getUrunLif());
		getUrunIcerik().setUrunProtein(getUrunIcerikList().get(0).getUrunProtein());
		getUrunIcerik().setUrunSeker(getUrunIcerikList().get(0).getUrunSeker());
		getUrunIcerik().setUrunTransYag(getUrunIcerikList().get(0).getUrunTransYag());
		getUrunIcerik().setUrunTuz(getUrunIcerikList().get(0).getUrunTuz());
		getUrunIcerik().setUrunYag(getUrunIcerikList().get(0).getUrunYag());
		getUrunIcerikList().get(0).setEditable(false);
		System.out.print("");
	}

	public void arananUrunBulunduktanSonraGuncelle(ActionEvent event) throws IOException {
		urunOzellikIcerikVitaminDoldur();
		urunService.urunGuncelle(getUrunOzellik());
		FacesContext.getCurrentInstance().getExternalContext().redirect("YeniUrunEklemeSayfasi.xhtml");
	}
	
	public void urunGuncelle(ActionEvent event) throws IOException {
		urunOzellikIcerikVitaminDoldur();
		urunService.urunGuncelle(getUrunOzellik());
		FacesContext.getCurrentInstance().getExternalContext().redirect("UrunGuncellemeSayfasi.xhtml");
	}

	public String urunSil() {
		boolean success = urunService.urunSil(getSelectedItems());
		if (success == true) {
			FacesContext.getCurrentInstance().addMessage("formid:silbutton", commandLinkMesajUret(true));
			setUrunSayisi(getUrunSayisi() - 1);
			urunOzellikList = null;
			urunIcerikList = null;
			return "urunAnasayfa.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage("formid:silbutton", commandLinkMesajUret(false));
			return "Anasayfa.xhtml?faces-redirect=true";
		}
	}

	public String guncellemeIptal() {
		return "UrunGuncellemeSayfasi.xhtml?faces-redirect=true";
	}

	public void barkodNoYaDaIsmeGoreUrunAra(ActionEvent event){
		if (getBarkodNo() != "") {
			UrunOzellik urun = urunService.barkodNoIleUrunArama(getBarkodNo());
			setButonaBasildimi(true);
			if (urun != null) {
				getUrunOzellikList().add(urun);
				getUrunIcerikList().add(urun.getIcerik());
				setUrunVitamin(urun.getVitamin());
				urunListeleriniDoldur();
			} else {
				setUrunSayisi(0);
				urunOzellikList = new ArrayList<>();
				urunIcerikList = new ArrayList<>();
				urunVitamin = new UrunVitamin();
			}
		} else if (getUrunIsim() != "") {
			ArrayList<UrunOzellik> urunlist = urunService.urunIsimIleUrunArama(getUrunIsim());
			if (urunlist != null) {
				getUrunOzellikList().addAll(urunlist);
				getUrunIcerikList().add(urunlist.get(0).getIcerik());
				setUrunVitamin(urunlist.get(0).getVitamin());
				urunListeleriniDoldur();
			} else {
				setUrunSayisi(0);
				urunOzellikList = new ArrayList<>();
				urunIcerikList = new ArrayList<>();
				urunVitamin = new UrunVitamin();
			}
		} else {
			// facesMesajOlustur("Sadece bir özellik ile arama yapabilirsiniz.");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("YeniUrunEklemeSayfasi.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<UrunOzellik> getSelectedItems() {

		for (int i = 0; i < getUrunOzellikList().size(); i++) {

			if (getUrunOzellikList().get(i).isSelected() == true) {
				getSelectableItems().add(getUrunOzellikList().get(i));
			}
		}
		return selectableItems;

	}
	
	public FacesMessage commandLinkMesajUret(boolean flag) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		if (flag) {
			message.setSummary("ürün silindi");
			message.setDetail("ürün silindi");
		} else {
			message.setSummary("ürün silinemedi");
			message.setDetail("ürün silinemedi");
		}
		return message;
	}
	
	public void raporlariDenetle() {
		// enCokOkutulan=enCokOkutulanUrunuBul();
		setEnCokTuketilen(enCokTuketilenUrunuBul());
		setEnCokOkutulan(enCokOkutulanUrunuBul());
		setTavsiyeyeUymaOraný(urunService.tavsiyeyeUymaOraniniBul());
	}

	public UrunOzellik enCokTuketilenUrunuBul() {
		setEnCokTuketilen(urunService.raporTüketim());
		return enCokTuketilen;
	}

	public UrunOzellik enCokOkutulanUrunuBul() {
		setEnCokOkutulan(urunService.raporOkutma());
		return getEnCokOkutulan();
	}
	
	public int getUrunSayisi() {
		if (getUrunOzellikList() != null) {
			setUrunSayisi(getUrunOzellikList().size());
		}
		return urunSayisi;
	}

	public void setUrunSayisi(int urunSayisi) {
		this.urunSayisi = urunSayisi;
	}

	public ArrayList<UrunOzellik> getSelectableItems() {
		return selectableItems;
	}

	public void setSelectableItems(ArrayList<UrunOzellik> selectableItems) {
		this.selectableItems = selectableItems;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void edit(ArrayList<UrunOzellik> urunOzellik) {
		this.urunOzellikList = urunOzellik;
		this.edit = true;
	}

	public String getBarkodNo() {
		return this.barkodNo;
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

	public ArrayList<UrunOzellik> getUrunOzellikList() {
		return urunOzellikList;
	}

	public UrunOzellik getUrunOzellik() {
		return urunOzellik;
	}

	public void setUrunOzellik(UrunOzellik urunOzellik) {
		this.urunOzellik = urunOzellik;
	}

	public UrunIcerik getUrunIcerik() {
		return urunIcerik;
	}

	public void setUrunIcerik(UrunIcerik urunIcerik) {
		this.urunIcerik = urunIcerik;
	}

	public void setUrunOzellikList(ArrayList<UrunOzellik> urunOzellikList) {
		this.urunOzellikList = urunOzellikList;
	}

	public ArrayList<UrunIcerik> getUrunIcerikList() {
		return urunIcerikList;
	}

	public void setUrunIcerikList(ArrayList<UrunIcerik> urunIcerikList) {
		this.urunIcerikList = urunIcerikList;
	}

	public boolean getIsShowDataTable() {
		return showDataTable;
	}

	public void setShowDataTable(boolean showDataTable) {
		this.showDataTable = showDataTable;
	}

	public boolean isShowDataTable() {
		return getIsShowDataTable();
	}

	public UrunOzellik getEnCokOkutulan() {
		return enCokOkutulan;
	}

	public void setEnCokOkutulan(UrunOzellik enCokOkutulan) {
		this.enCokOkutulan = enCokOkutulan;
	}

	public boolean isButonaBasildimi() {
		return butonaBasildimi;
	}

	public void setButonaBasildimi(boolean butonaBasildimi) {
		this.butonaBasildimi = butonaBasildimi;
	}

	public UrunOzellik getEnCokTuketilen() {
		return enCokTuketilen;
	}

	public void setEnCokTuketilen(UrunOzellik enCokTuketilen) {
		this.enCokTuketilen = enCokTuketilen;
	}

	public UrunVitamin getUrunVitamin() {
		return urunVitamin;
	}

	public void setUrunVitamin(UrunVitamin urunVitamin) {
		this.urunVitamin = urunVitamin;
	}

	public void editOz(ActionEvent event) {
		getUrunOzellikList().get(0).setEditable(true);
	}

	public void editOzIptal(ActionEvent event) {
		getUrunOzellikList().get(0).setEditable(false);
	}

	public void editIc(ActionEvent event) {
		getUrunIcerikList().get(0).setEditable(true);
	}

	public void editIcIptal(ActionEvent event) {
		getUrunIcerikList().get(0).setEditable(false);

	}

	public double getTavsiyeyeUymaOraný() {
		return tavsiyeyeUymaOraný;
	}

	public void setTavsiyeyeUymaOraný(double tavsiyeyeUymaOraný) {
		this.tavsiyeyeUymaOraný = tavsiyeyeUymaOraný;
	}


};
