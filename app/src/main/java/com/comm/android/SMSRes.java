package com.comm.android;

/**
 * Created by kang on 16/12/15.
 */

public class SMSRes {
    boolean sent;
    String reason;

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
