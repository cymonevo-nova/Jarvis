package com.cymonevo.nova.jarvis.service.db;

import com.cymonevo.nova.jarvis.service.db.user.DBResult;

public interface DBCall {
    void onDBResponse(int code, DBResult result);
    void onDBFailure(int code, String message);
    void runOnUiThread(Runnable func);
}
