package kr.co.n3n.automotive.common.session;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.n3n.automotive.common.model.CommMap;



public class SessionInfo implements Serializable {
	private static final long serialVersionUID = 8474637359476757048L;
	
	private String userId ="";
	private String userNm ="";
	private String mbtlnum = "";
	private String grCodeId = "";
	private String token = "";
	private List<CommMap> userRole =new ArrayList<CommMap>();
	
	private String siteId ="";
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	public List<CommMap> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<CommMap> userRole) {
		this.userRole = userRole;
	}
	
	public String getMbtlnum() {
		return mbtlnum;
	}
	public void setMbtlnum(String mbtlnum) {
		this.mbtlnum = mbtlnum;
	}
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId= siteId;
	}
	public String getGrCodeId() {
		return grCodeId;
	}
	public void setGrCodeId(String grCodeId) {
		this.grCodeId = grCodeId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}