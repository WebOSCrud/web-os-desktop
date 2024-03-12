package cn.donting.web.os.desktop.exception;

import cn.donting.web.os.desktop.domain.ResponseBody;

public class ResponseBodyException extends RuntimeException{
  private   ResponseBody responseBody;

    public ResponseBodyException(ResponseBody responseBody) {
        super(responseBody.getMsg());
        this.responseBody = responseBody;
    }

    public ResponseBodyException(String errMsg) {
        super(errMsg);
        responseBody=ResponseBody.fail(errMsg);
    }
    public ResponseBodyException(int code,String errMsg) {
        super(errMsg);
        responseBody=ResponseBody.fail(code,errMsg);
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }
}
