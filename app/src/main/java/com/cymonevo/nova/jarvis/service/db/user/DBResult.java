package com.cymonevo.nova.jarvis.service.db.user;

public class DBResult {
    public int status;
    public String message;
    public Object data;

    public DBResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
