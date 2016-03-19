package com.magus.backend.model;

public class WalletProfile {

	private String firstName;
	private String lastName;
	private String emailId;
	private String mobile;
	private String birthDate;
	private String gender;
	private String ipConfig;
	private String platform;
	private String deviceId;
	private String state;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIpConfig() {
		return ipConfig;
	}
	public void setIpConfig(String ipConfig) {
		this.ipConfig = ipConfig;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public WalletProfile(String mobile) {
		super();
		this.mobile = mobile;
	}
	
	public WalletProfile(String firstName, String lastName, String emailId,
			String mobile, String birthDate, String gender, String ipConfig,
			String platform, String deviceId, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.gender = gender;
		this.ipConfig = ipConfig;
		this.platform = platform;
		this.deviceId = deviceId;
		this.state = state;
	}
	public WalletProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
