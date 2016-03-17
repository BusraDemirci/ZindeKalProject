package com.busra.bitirme.commons.entities.urun;

import com.busra.bitirme.commons.entities.Satici;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class UrunOzellik {
	
	@Id
	@GeneratedValue
	private Long urunID;
	private String barkodNo;
	private String urunIsim;
	private String kategori;
	private Date skt;
	private String urunIcerik;
	private int okutmaSayaci;
	private int tuketimSayaci;
	private boolean editable;
	private boolean selected;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "urunSatici", joinColumns = { @JoinColumn(name = "urunID") }, inverseJoinColumns = { @JoinColumn(name = "saticiID") })
	private List<Satici> saticilar;
	
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.ALL})
	//@JoinTable(name = "urunIcerik", joinColumns = { @JoinColumn(name = "urunID") }, inverseJoinColumns = { @JoinColumn(name = "icerikID") })
	private UrunIcerik icerik;
	
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.ALL})
	//@JoinTable(name = "urunVitamin", joinColumns = { @JoinColumn(name = "urunID") }, inverseJoinColumns = { @JoinColumn(name = "urunVitaminID") })
	private UrunVitamin vitamin;

	public Long getUrunID() {
		return urunID;
	}

	public void setUrunID(Long urunID) {
		this.urunID = urunID;
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

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public Date getSkt() {
		return skt;
	}

	public void setSkt(Date skt) {
		this.skt = skt;
	}

	public String getUrunIcerik() {
		return urunIcerik;
	}

	public void setUrunIcerik(String urunIcerik) {
		this.urunIcerik = urunIcerik;
	}

	public List<Satici> getSaticilar() {
		return saticilar;
	}

	public void setSaticilar(List<Satici> saticilar) {
		this.saticilar = saticilar;
	}

	public int getTuketimSayaci() {
		return tuketimSayaci;
	}

	public void setTuketimSayaci(int tuketimSayaci) {
		this.tuketimSayaci = tuketimSayaci;
	}

	public int getOkutmaSayaci() {
		return okutmaSayaci;
	}

	public void setOkutmaSayaci(int okutmaSayaci) {
		this.okutmaSayaci = okutmaSayaci;
	}

	public UrunIcerik getIcerik() {
		return icerik;
	}

	public void setIcerik(UrunIcerik icerik) {
		this.icerik = icerik;
	}

	public UrunVitamin getVitamin() {
		return vitamin;
	}

	public void setVitamin(UrunVitamin vitamin) {
		this.vitamin = vitamin;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
