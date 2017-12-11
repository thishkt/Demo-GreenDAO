package com.calvin.demogreendao;

import android.content.Context;

import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;

/**
 * Created by calvin on 2017/12/11.
 */

public class DBHelper extends DaoMaster.DevOpenHelper {

    public Database db;
    private DaoSession daoSession;
    private AsyncSession asyncSession;


    public DBHelper(Context context) {
        super(context, "demo-greendao");
        db = getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        asyncSession = daoSession.startAsyncSession();
    }


    public NoteDao getNoteDao() {
        return daoSession.getNoteDao();
    }


    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
