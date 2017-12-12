package com.calvin.demogreendao;

import android.content.Context;

import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;

import java.util.List;

/**
 * Created by calvin on 2017/12/11.
 */

public class DBHelper extends DaoMaster.DevOpenHelper {

    //資料庫名稱
    private static final String dbName = "demogreendao";
    private static DBHelper INSTANCE;
    public Database db;
    private DaoSession daoSession;
    private AsyncSession asyncSession;


    public DBHelper(Context context) {
        super(context, dbName);
        db = getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        asyncSession = daoSession.startAsyncSession();
    }

    public static DBHelper getInstance() {
        return INSTANCE;
    }

    public static void setInstance(Context context) {
        INSTANCE = new DBHelper(context);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }

    private NoteDao getNoteDao() {
        return daoSession.getNoteDao();
    }

    //獲取全部「筆記」資料
    public List<Note> getAllNote() {

        List<Note> note_List = getNoteDao().queryBuilder().list();
//若需轉型 ArrayList 給 Adapter
//        ArrayList<Note> note_ArrList = new ArrayList<>();
//        if (note_List != null && note_List.size() > 0) {
//            note_ArrList.addAll(note_List);
//        }
        return note_List;
    }

    //新增「筆記」資料
    public void addNote(String txtNote) {
        Note note = new Note();
        note.setText(txtNote);
        getNoteDao().insert(note);
    }

    //修改「筆記」資料
    public void updateNote(String id, String txtNote) {
        Note note = getNoteDao().queryBuilder().where(NoteDao.Properties.Id.eq(id)).unique();
        note.setText(txtNote);
        getNoteDao().update(note);
    }

    //刪除「筆記」資料
    public void deleteNote(Long id) {
        getNoteDao().deleteByKey(id);
    }

    //清除所有「筆記」資料
    public void deleteAllTable() {
        getNoteDao().deleteAll();
    }
}
