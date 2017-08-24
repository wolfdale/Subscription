package com.api.customer;

public class subscriptionJSON {

	String subID;
	String subName;
	String requestTime;
	
	public subscriptionJSON(String subId,String subName, String requestTime){
		this.subID = subId;
		this.subName = subName;
		this.requestTime = requestTime;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubID() {
		return subID;
	}
	public void setSubID(String subID) {
		this.subID = subID;
	}
	
}
