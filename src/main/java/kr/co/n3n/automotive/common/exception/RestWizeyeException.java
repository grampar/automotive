package kr.co.n3n.automotive.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestWizeyeException extends Exception {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestWizeyeException() {
		super();
	}
	
	public RestWizeyeException(String msg) {
		super(msg);		
	}
	
	public RestWizeyeException(Exception e) {		
		super(e);
	}
}
