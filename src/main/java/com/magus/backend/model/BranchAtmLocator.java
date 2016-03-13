package com.magus.backend.model;


public class BranchAtmLocator extends AuthorizationFailed{

	public BranchAtmLocator(Integer code, String description, String message) {
		super(code, description, message);
	}

	private String pincode;
	private String type;
	private String flag;
	private String address;
	private String latitude;
	private String longitude;
	private String city;
	private String state;
	private String branchname;
	private String phoneno;
	private String ifsc_code;

	public BranchAtmLocator() {

	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public BranchAtmLocator(String code, String description, String message,
			String pincode, String type, String flag, String address,
			String latitude, String longitude, String city, String state,
			String branchname, String phoneno, String ifsc_code) {
		super();
		this.pincode = pincode;
		this.type = type;
		this.flag = flag;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
		this.branchname = branchname;
		this.phoneno = phoneno;
		this.ifsc_code = ifsc_code;
	}

	
}
