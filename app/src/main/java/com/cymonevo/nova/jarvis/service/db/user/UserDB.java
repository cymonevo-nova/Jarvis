package com.cymonevo.nova.jarvis.service.db.user;

import com.cymonevo.nova.jarvis.config.DB;
import com.cymonevo.nova.jarvis.core.room.RoomClient;
import com.cymonevo.nova.jarvis.service.db.DBCall;
import com.cymonevo.nova.jarvis.service.db.SqliteDB;
import com.cymonevo.nova.jarvis.service.db.user.entity.UserData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class UserDB {
    private SqliteDB db;

    public UserDB(RoomClient client) {
        db = client.getInstance();
    }

    public void listUsers(DBCall activity, int code) {
        Observable.just(this.db)
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<SqliteDB>() {
                    @Override
                    public void onNext(SqliteDB sqliteDB) {
                        DBResult result;
                        List<UserData> users = sqliteDB.userDao().getAll();
                        if (users.size() < 1) {
                            result = new DBResult(DB.STATUS_ERROR_NO_ROW, DB.MSG_ERROR_NO_ROW, null);
                        } else {
                            result = new DBResult(DB.STATUS_OK, DB.MSG_OK, users);
                        }
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                activity.onDBResponse(code, result);
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                activity.onDBFailure(code, e.getMessage());
                            }
                        });
                        this.dispose();
                    }

                    @Override
                    public void onComplete() {
                        this.dispose();
                    }
                });
    }
}
