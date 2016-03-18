package com.magus.backend.model;

public class PocketPostCredit {

	private String id_type ;
	private String id_value;
	private String auth_type ;
	private String auth_data ;
	private String txn_id;
	private String amount;
	private String promocode ;
	private String remarks ;
	private String sub_merchant;
	private String latitude;
	private String longitude ;
	private String imei;
	private String device_id ;
	private String ip_address;
	private String os;
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public String getId_value() {
		return id_value;
	}
	public void setId_value(String id_value) {
		this.id_value = id_value;
	}
	public String getAuth_type() {
		return auth_type;
	}
	public void setAuth_type(String auth_type) {
		this.auth_type = auth_type;
	}
	public String getAuth_data() {
		return auth_data;
	}
	public void setAuth_data(String auth_data) {
		this.auth_data = auth_data;
	}
	public String getTxn_id() {
		return txn_id;
	}
	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSub_merchant() {
		return sub_merchant;
	}
	public void setSub_merchant(String sub_merchant) {
		this.sub_merchant = sub_merchant;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public PocketPostCredit(String id_type, String id_value, String auth_type,
			String auth_data, String txn_id, String amount, String promocode,
			String remarks, String sub_merchant, String latitude,
			String longitude, String imei, String device_id, String ip_address,
			String os) {
		super();
		this.id_type = id_type;
		this.id_value = id_value;
		this.auth_type = auth_type;
		this.auth_data = auth_data;
		this.txn_id = txn_id;
		this.amount = amount;
		this.promocode = promocode;
		this.remarks = remarks;
		this.sub_merchant = sub_merchant;
		this.latitude = latitude;
		this.longitude = longitude;
		this.imei = imei;
		this.device_id = device_id;
		this.ip_address = ip_address;
		this.os = os;
	}
	public PocketPostCredit() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
