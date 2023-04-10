package com.appt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nse {
	
	@Id
	private String securityCode;
	private String symbol;
	private String securityName;
	private String isinNo;
	private String sector;
	private String industry;
	private String exchange;
	private String currency;
	private String gics;
	private String price;
	private String country;
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getIsinNo() {
		return isinNo;
	}
	public void setIsinNo(String isinNo) {
		this.isinNo = isinNo;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getGics() {
		return gics;
	}
	public void setGics(String gics) {
		this.gics = gics;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Nse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nse(String securityCode, String symbol, String securityName, String isinNo, String sector, String industry,
			String exchange, String currency, String gics, String price, String country) {
		super();
		this.securityCode = securityCode;
		this.symbol = symbol;
		this.securityName = securityName;
		this.isinNo = isinNo;
		this.sector = sector;
		this.industry = industry;
		this.exchange = exchange;
		this.currency = currency;
		this.gics = gics;
		this.price = price;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Nse [securityCode=" + securityCode + ", symbol=" + symbol + ", securityName=" + securityName
				+ ", isinNo=" + isinNo + ", sector=" + sector + ", industry=" + industry + ", exchange=" + exchange
				+ ", currency=" + currency + ", gics=" + gics + ", price=" + price + ", country=" + country + "]";
	}
}
