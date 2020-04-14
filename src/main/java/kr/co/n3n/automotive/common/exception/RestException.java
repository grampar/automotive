package kr.co.n3n.automotive.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestException extends Exception {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestException() {
		
	}
	
	public RestException(String msg) {
		super(msg);		
	}
	
	public RestException(Exception e) {		
		super(e);
	}
}
