package com.busra.bitirme.commons.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.busra.bitirme.commons.entities.urun.UrunOzellik;

@Entity
public class Satici {
	
	@Id
	@GeneratedValue
	private Long saticiID;
	private String saticiKimlikNo;//text boxdan aldýðýmýz string olduðu ve bu (önceden) Long olduðu için null döndü kimlik no bu nedenle String e döndürdüm
	private String kurumKodu;
	private String kurumAdi;
	private String saticiIsim;
	private String saticiSoyIsim;
	private String saticiTelefon;
	private String saticiMail;
	private String saticiSifre;
	private String isAdmin;
	private String isSatici;
	private String onayDurumu;//onay durumu bir olmayanlarý getirecek uyelik bekleyenlere týkladýðýmda,
	//yeni tablo ekleyip ayný bilgileri duplicate tutmak yerine bir kolon. sign in e bastýðýnda gene bu
	//tabloya eklenecek ama bu kolonu sýfýr olarak
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "saticiUrun", joinColumns = { @JoinColumn(name = "saticiID") }, inverseJoinColumns = { @JoinColumn(name = "urunID") })
	private List <UrunOzellik> urunler;

	public List<UrunOzellik> getUye() {
		return urunler;
	}
	public void setUye(List<UrunOzellik> urunler) {
		this.urunler = urunler;
	}
	
	public String getOnayDurumu() {
		return onayDurumu;
	}
	public void setOnayDurumu(String onayDurumu) {
		this.onayDurumu = onayDurumu;
	}
	public Long getSaticiID() {
		return saticiID;
	}
	public void setSaticiID(Long saticiID) {
		this.saticiID = saticiID;
	}
	public String getSaticiKimlikNo() {
		return saticiKimlikNo;
	}
	public void setSaticiKimlikNo(String saticiKimlikNo) {
		this.saticiKimlikNo = saticiKimlikNo;
	}
	public String getKurumKodu() {
		return kurumKodu;
	}
	public void setKurumKodu(String kurumKodu) {
		this.kurumKodu = kurumKodu;
	}
	public String getKurumAdi() {
		return kurumAdi;
	}
	public void setKurumAdi(String kurumAdi) {
		this.kurumAdi = kurumAdi;
	}
	public String getSaticiIsim() {
		return saticiIsim;
	}
	public void setSaticiIsim(String saticiIsim) {
		this.saticiIsim = saticiIsim;
	}
	public String getSaticiSoyIsim() {
		return saticiSoyIsim;
	}
	public void setSaticiSoyIsim(String saticiSoyIsim) {
		this.saticiSoyIsim = saticiSoyIsim;
	}
	public String getSaticiTelefon() {
		return saticiTelefon;
	}
	public void setSaticiTelefon(String saticiTelefon) {
		this.saticiTelefon = saticiTelefon;
	}
	public String getSaticiMail() {
		return saticiMail;
	}
	public void setSaticiMail(String saticiMail) {
		this.saticiMail = saticiMail;
	}
	public String getSaticiSifre() {
		return saticiSifre;
	}
	public void setSaticiSifre(String saticiSifre) {
		this.saticiSifre = saticiSifre;
	}
	public String getIsSatici() {
		return isSatici;
	}
	public void setIsSatici(String isSatici) {
		this.isSatici = isSatici;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
}
