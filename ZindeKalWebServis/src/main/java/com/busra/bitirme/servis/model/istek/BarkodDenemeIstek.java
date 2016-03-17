package com.busra.bitirme.servis.model.istek;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BarkodDenemeIstek {
	
	private String barkodNo;

	public String getBarkodNo() {
		return barkodNo;
	}

	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}
}
