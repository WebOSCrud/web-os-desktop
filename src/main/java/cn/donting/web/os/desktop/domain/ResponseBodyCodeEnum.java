package cn.donting.web.os.desktop.domain;

/**
 * 消息返回类型枚举
 * @see ResponseBody
 */
public enum ResponseBodyCodeEnum {
    OK(200, "成功");
    /**
     * 状态码
     */
    private final int code;
    /**
     * 消息
     */
    private final String msg;
    private final int httpStatus ;

    ResponseBodyCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.httpStatus = 200;
    }

    ResponseBodyCodeEnum(int code, int httpStatus, String msg) {
        this.code = code;
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
