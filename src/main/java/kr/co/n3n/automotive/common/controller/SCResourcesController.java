package kr.co.n3n.automotive.common.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value={"/scresources"}, method={RequestMethod.POST, RequestMethod.GET})
public class SCResourcesController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("/commonlib/js")
    public String getCommonlibJs() {
        return "common/common_js";
    }
    
    @RequestMapping("/commonlib/css")
    public String getCommonlibCss() {
        return "common/common_css";
    }
    
    
}