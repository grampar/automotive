package kr.co.n3n.automotive.common.login;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.co.n3n.automotive.common.exception.BaseException;
import kr.co.n3n.automotive.common.model.CommMap;
import kr.co.n3n.automotive.common.session.SessionInfo;
import kr.co.n3n.automotive.common.util.StdResponse;





@Controller
public class LoginController {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping("/login")
    public String login(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		return "login/login";
    }
	
	@RequestMapping(value="/login/auth", method={RequestMethod.POST})	
	public void   messageSendingHistoryList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws BaseException, IOException{
		
		
		String user_id = request.getParameter("user_id");
		String user_pwd= request.getParameter("user_pwd");
		
		
		CommMap param=new CommMap();
		param.put("user_id", user_id);
		param.put("tmp_pwd", user_pwd);
		param.put("user_pwd", param.getPassword("tmp_pwd"));
		
		CommMap retMap=loginService.getUserInfo(param);
		
		if(retMap!=null) {
			
			if(retMap.getString("user_id").equals(user_id)) {
				
				SessionInfo sInfo=new SessionInfo();
				
				sInfo.setUserId(retMap.getString("user_id"));
				sInfo.setUserNm(retMap.getString("user_nm"));
				sInfo.setMbtlnum(retMap.getString("mbtlnum"));	
				sInfo.setGrCodeId(retMap.getString("gr_code_id"));
				sInfo.setSiteId("siteID");
				
				List<CommMap> roleList=loginService.getRole(param);
				sInfo.setUserRole(roleList);				
				session.setAttribute("sessionInfo", sInfo);
				
				response.sendRedirect("/main");
			}else {					
				response.sendRedirect("/login");
			}
			
		}else {
			response.sendRedirect("/login");
		}
		
	}
	
	
	@RequestMapping(value="/login/auth2", method={RequestMethod.POST, RequestMethod.GET})	
	public void   auth2(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws BaseException, IOException{
		
		
		String user_id = request.getParameter("user_id");
		
		
		
		
		
		
		Map<String, Object>  retMap=getWizeyeSession(user_id);
		  System.out.println("===================retMap:"+retMap);
		  
		  
		  
		  String data=(String)retMap.get("body");
		  System.out.println("===================data:"+data); 
		  Gson gson=new Gson();
		  Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
		  List<Map<String, Object>> bodyList = (List<Map<String,Object>>)gson.fromJson(data, type);
		  System.out.println("===================bodyList:"+bodyList);
		  
		  Map<String, Object> body=bodyList.get(0); 
		 
		  String  token=(String)body.get("token");
		  System.out.println("===================user_id:"+user_id+"//token"+token); 
		  CommMap reqParam =new CommMap(); 
		  reqParam.put("user_id", user_id);
		  CommMap  loginMap=loginService.getUserInfoNoPwd(reqParam);
		  
		  
		  SessionInfo sInfo=new SessionInfo();
		  
		  sInfo.setUserId(loginMap.getString("USER_ID"));
		  sInfo.setUserNm(loginMap.getString("USER_NM"));
		  sInfo.setMbtlnum(loginMap.getString("MBTLNUM"));
		  sInfo.setGrCodeId(loginMap.getString("GR_CODE_ID"));
		  sInfo.setToken(token);
		  
		  List<CommMap> roleList=loginService.getRole(reqParam);
		  sInfo.setUserRole(roleList); 
		  session.setAttribute("sessionInfo", sInfo);
		  session.setMaxInactiveInterval(30*60);
		
		
		
		
		response.sendRedirect("/main");
			
		
	}
	
	
	@RequestMapping(value="/login/fail", method={RequestMethod.POST})	
	public String   loginfail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws BaseException, IOException{
		
		
		return "login/fail";
			
		
	}
	
	private Map<String, Object> getWizeyeSession(String user_id) {
		
		String url=restApiProperties.getTestBaseUrl()+"/scm/current-session";
		Map<String, Object> map=new HashMap<String, Object>();		
		map.put("siteId", restApiProperties.getSiteId());
		map.put("userId", user_id);
		
		
		Gson gson = new Gson();
        Type gsonType = new TypeToken<HashMap<String ,Object>>(){}.getType();
        String gsonString = gson.toJson(map,gsonType);
        
		String jsonParam=gsonString;
		Map<String, Object> retMap=HttpSender.sendWizeye(url, jsonParam);
		
		return retMap;
	}
	
	
	@RequestMapping(value="/userMenu", method={RequestMethod.POST, RequestMethod.GET})	
	public ResponseEntity<StdResponse>  getUserMenu(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws BaseException, IOException{
		
				
		
		StdResponse stdResponse = new StdResponse();		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		
		String user_id=sessionInfo.getUserId();
		
		CommMap reqParam=new CommMap();
		reqParam.put("USER_ID", user_id);
		List<CommMap> menuList=loginService.getUserMenu(reqParam);

		
		
		return new ResponseEntity<StdResponse>(stdResponse.setSuccess(menuList), HttpStatus.OK);
		
	}
}
