package com.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Movie {

	@Id
	String mId;
	String mName;
	String mDescription;
	String mLength;
	String mUserOrderNum;
	
	
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmDescription() {
		return mDescription;
	}
	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}
	public String getmLength() {
		return mLength;
	}
	public void setmLength(String mLength) {
		this.mLength = mLength;
	}
	public String getmUserOrderNum() {
		return mUserOrderNum;
	}
	public void setmUserOrderNum(String mUserOrderNum) {
		this.mUserOrderNum = mUserOrderNum;
	}
	
	
}
