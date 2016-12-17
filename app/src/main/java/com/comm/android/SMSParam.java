package com.comm.android;

/**
 * Created by kang on 16/12/15.
 */

public class SMSParam {
    String action;
    String phone;

    public SMSParam(String action, String phone) {
        this.action = action;
        this.phone = phone;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
