package com.cymonevo.nova.template.service.db;

import com.cymonevo.nova.template.service.db.user.DBResult;

public interface DBCall {
    void onDBResponse(int code, DBResult result);
    void onDBFailure(int code, String message);
    void runOnUiThread(Runnable func);
}
