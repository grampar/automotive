package kr.co.n3n.automotive.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseException extends Exception {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
	}
	
	public BaseException(String msg) {
		super(msg);		
	}
	
	public BaseException(Exception e) {		
		super(e);
	}
	
}
