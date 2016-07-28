package cn.edu.upc.yb.integrate.second.dto;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public class JsonMes {
    private int code;           //0=parse error;
    private String message;

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
