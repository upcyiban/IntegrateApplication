package cn.edu.upc.yb.integrate.calendar.dto;

/**
 * Created by Jaxlying on 2016/7/9.
 */
public class JsonMes {
    private int code;
    private String message;

    public JsonMes() {
    }
    public JsonMes(int code, String message) {
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
