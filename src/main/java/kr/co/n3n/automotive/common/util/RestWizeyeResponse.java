package kr.co.n3n.automotive.common.util;

public class RestWizeyeResponse {
    
	 public static enum StatusCode  {
		SUCCESS("200"), FAIL("403");
        public final String value;
        private StatusCode(final String value) {
            this.value = value;
        }
        
        

    }
    private String code;
    private String message;
    private Object body;
    
   
    public RestWizeyeResponse() {
    }
    
    

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}

	public RestWizeyeResponse setSuccess() {
        this.code = StatusCode.SUCCESS.value;
        return this;
    }

    public RestWizeyeResponse setSuccess(String message) {
        this.code = StatusCode.SUCCESS.value;
        this.message = message;
        return this;
    }
    
    public RestWizeyeResponse setSuccess(Object o) {
        this.code = StatusCode.SUCCESS.value;
        this.body = o;
        return this;
    }
    
    public RestWizeyeResponse setSuccess(String message, Object o) {
        this.code = StatusCode.SUCCESS.value;
        this.message = message;
        this.body = o;
        return this;
    }
    
    public RestWizeyeResponse setFail(Exception e) {
        this.code = StatusCode.FAIL.value;
        this.message = e.getMessage();
        return this;
    }
    
   
}

