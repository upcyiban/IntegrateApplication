package cn.edu.upc.yb.integrate.deliciousfood.dto;

/**
 * Created by 陈子枫 on 2017/2/23.
 */
public class ResultData<T> {
    private T data;
    private int code = 200;
    private String msg;
    private boolean success = true;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if (200 != code){
            success = false;
        }
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
