package kr.co.n3n.automotive.common.login;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.n3n.automotive.common.dao.CommonDao;
import kr.co.n3n.automotive.common.exception.BaseException;
import kr.co.n3n.automotive.common.model.CommMap;



@Service
public class LoginServiceImpl implements LoginService {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	@Autowired
	CommonDao commonDao;
	
	

	@Override
	public CommMap getUserInfo(CommMap reqParam) throws BaseException {
		// TODO Auto-generated method stub
		
		CommMap result = null;
		try {
			
			result= commonDao.selectOne("login.getUser",reqParam);
			
		}catch(Exception e) {			
			throw new BaseException(e);
		}
			        
		return result;		
		
	}



	@Override
	public List<CommMap> getRole(CommMap reqParam) throws BaseException {
		// TODO Auto-generated method stub
		List<CommMap> result = null;
		try {
			
			result= commonDao.selectList("login.getUserRole",reqParam);
			
		}catch(Exception e) {			
			throw new BaseException(e);
		}
			        
		return result;		
	}



	@Override
	public List<CommMap> getUserMenu(CommMap reqParam) throws BaseException {
		// TODO Auto-generated method stub
		List<CommMap> result = null;
		try {
			
			result= commonDao.selectList("user_menu.getUserMenu",reqParam);
			
		}catch(Exception e) {			
			throw new BaseException(e);
		}
			        
		return result;
	}



	@Override
	public CommMap getUserInfoNoPwd(CommMap reqParam) throws BaseException {
		// TODO Auto-generated method stub
		CommMap result = null;
		try {
			
			result= commonDao.selectOne("login.getUserNoPwd",reqParam);
			
		}catch(Exception e) {			
			throw new BaseException(e);
		}
			        
		return result;		
	}
	
	
	
	
	
}
