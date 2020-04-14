package kr.co.n3n.automotive.common.util;

public class RestResponse {
    
	 public static enum StatusCode  {
		SUCCESS("0"), FAIL("1");
        public final String value;
        private StatusCode(final String value) {
            this.value = value;
        }
        
        

    }
    private String retCode;
    private String errMsg;
    private Object data;
    
   
    public RestResponse() {
    }
    
    
    public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public RestResponse setSuccess() {
        this.retCode = StatusCode.SUCCESS.value;
        return this;
    }

    public RestResponse setSuccess(String message) {
        this.retCode = StatusCode.SUCCESS.value;
        this.errMsg = message;
        return this;
    }
    
    public RestResponse setSuccess(Object o) {
        this.retCode = StatusCode.SUCCESS.value;
        this.data = o;
        return this;
    }
    
    public RestResponse setFail(Exception e) {
        this.retCode = StatusCode.FAIL.value;
        this.errMsg = e.getMessage();
        return this;
    }
    
    
    
   
}
