package cn.edu.upc.yb.integrate.dormsearch.model;

/**
 * Created by skyADMIN on 16/6/27.
 */
public class ErrorJsonMsg {
    private int code;
    private String message;

    public ErrorJsonMsg() {
        code = 1;
        message = "未知错误";
    }

    public ErrorJsonMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
