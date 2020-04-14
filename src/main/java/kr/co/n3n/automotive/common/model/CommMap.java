package kr.co.n3n.automotive.common.model;

import java.security.MessageDigest;
import java.util.HashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommMap extends HashMap<String, Object> {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public CommMap() {
		
	}
	
	public String getString(String key) {
		
		String retVal="";
		try {
			if(this.get(key)!=null) {
				retVal=this.get(key).toString();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	
	public int getInt(String key) {
		int retVal=0;
		try {
			if(this.get(key)!=null) {
				retVal=Integer.parseInt(this.get(key).toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public int getInt(String key, int defaultValue) {
		int retVal=defaultValue;
		try {
			if(this.get(key)!=null) {
				retVal=Integer.parseInt(this.get(key).toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public Double getDouble(String key) {
		
		double retVal=0;
		try {
			if(this.get(key)!=null) {
				retVal=Double.parseDouble((String)this.get(key));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Double getDouble(String key, double defaultValue) {
		
		double retVal=defaultValue;
		try {
			if(this.get(key)!=null) {
				retVal=Double.parseDouble((String)this.get(key));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	
}
