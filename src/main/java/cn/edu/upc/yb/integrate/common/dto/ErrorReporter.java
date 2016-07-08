package cn.edu.upc.yb.integrate.common.dto;

/**
 * Created by skyADMIN on 16/7/8.
 */
public class ErrorReporter {

    private int code;           //0=parse error;
    private String message;

    public ErrorReporter() {
    }

    public ErrorReporter(int code, String message) {
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
