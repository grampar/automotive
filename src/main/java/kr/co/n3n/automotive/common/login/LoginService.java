package kr.co.n3n.automotive.common.login;

import java.util.List;

import kr.co.n3n.automotive.common.exception.BaseException;
import kr.co.n3n.automotive.common.model.CommMap;



public interface LoginService {
	
	public CommMap getUserInfo(CommMap reqParam) throws BaseException;
	
	public CommMap getUserInfoNoPwd(CommMap reqParam) throws BaseException;
	
	public List<CommMap> getRole(CommMap reqParam) throws BaseException;
	
	public List<CommMap> getUserMenu(CommMap reqParam) throws BaseException;
	
	
	
}
