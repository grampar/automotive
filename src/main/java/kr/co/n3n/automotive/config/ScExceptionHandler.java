package kr.co.n3n.automotive.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.n3n.automotive.common.exception.BaseException;
import kr.co.n3n.automotive.common.exception.RestException;
import kr.co.n3n.automotive.common.exception.RestWizeyeException;
import kr.co.n3n.automotive.common.util.RestResponse;
import kr.co.n3n.automotive.common.util.RestWizeyeResponse;
import kr.co.n3n.automotive.common.util.StdResponse;



@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ScExceptionHandler {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(BaseException.class)
	@ResponseBody
	public ResponseEntity<?> handleSomeException(HttpServletRequest request, BaseException e){
		
		StdResponse stdResponse = new StdResponse();
		
		e.printStackTrace();		
		return new ResponseEntity<>(stdResponse.setFail("오류가 발생하였습니다.관리자에게 문의하세요."), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RestException.class)
	@ResponseBody
	public ResponseEntity<?> restException(HttpServletRequest request, RestException e){
		
		RestResponse restResponse = new RestResponse();
		
		e.printStackTrace();
		return new ResponseEntity<>(restResponse.setFail(e), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RestWizeyeException.class)
	@ResponseBody
	public ResponseEntity<?> restWizeyeException(HttpServletRequest request, RestWizeyeException e){
		
		RestWizeyeResponse restResponse = new RestWizeyeResponse();		
		e.printStackTrace();
		return new ResponseEntity<>(restResponse.setFail(e), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)	
	public ResponseEntity<?> handleException(HttpServletRequest request, Exception e){
		RestResponse restResponse = new RestResponse();		
		e.printStackTrace();
		return new ResponseEntity<>(restResponse.setFail(e), HttpStatus.BAD_REQUEST);
	}
		
	
	
}
