package com.appt.dto;

public class NseResponseDto {
	
	private String securityCode;
	private String symbol;
	private String securityName;
	private String IsinNo;
	private String sector;
	private String industry;
	private String price;
	private String gics;
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
		return IsinNo;
	}
	public void setIsinNo(String isinNo) {
		IsinNo = isinNo;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGics() {
		return gics;
	}
	public void setGics(String gics) {
		this.gics = gics;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public NseResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NseResponseDto(String securityCode, String symbol, String securityName, String isinNo, String sector,
			String industry, String price, String gics, String country) {
		super();
		this.securityCode = securityCode;
		this.symbol = symbol;
		this.securityName = securityName;
		IsinNo = isinNo;
		this.sector = sector;
		this.industry = industry;
		this.price = price;
		this.gics = gics;
		this.country = country;
	}
	@Override
	public String toString() {
		return "NseResponseDto [securityCode=" + securityCode + ", symbol=" + symbol + ", securityName=" + securityName
				+ ", IsinNo=" + IsinNo + ", sector=" + sector + ", industry=" + industry + ", price=" + price
				+ ", gics=" + gics + ", country=" + country + "]";
	}
}
