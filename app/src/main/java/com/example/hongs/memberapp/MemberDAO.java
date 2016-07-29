package com.example.hongs.memberapp;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongs on 2016-07-27.
 */
public class MemberDAO extends SQLiteOpenHelper{

    public static final String TABLE_NAME = "member";
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String SSN = "ssn";
    public static final String EMAIL = "email";
    public static final String PROFILE = "profile";
    public static final String PHONE = "phone";

    public MemberDAO(Context context) {
        super(context, "hongsdb", null, 1);
        this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists "
                +TABLE_NAME
                +"("
                +ID+" text primary key, "
                +PW+" text, "
                +NAME+" text, "
                +SSN+" text, "
                +EMAIL+" text,"
                +PROFILE+" text,"
                +PHONE+" text);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql ="";
             db.execSQL(sql);
        this.onCreate(db);
    }
    public int insert(MemberBean mem) {
        int result = 0;
        String sql = "insert into "+TABLE_NAME
                +String.format("(%s,%s,%s,%s,%s,%s,%s)",ID,PW,NAME,SSN,EMAIL,PROFILE,PHONE)
                +String.format(" values('%s','%s','%s','%s','%s','%s','%s');"
                ,mem.getId()
                ,mem.getPw()
                ,mem.getName()
                ,mem.getSsn()
                ,mem.getEmail()
                ,mem.getProfile()
                ,mem.getPhone());
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);
        return result;
    }
    public void update(MemberBean mem) {
        String sql = "update member set pw = ?, email = ? where id = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

    }
    public ArrayList<MemberBean> list() {
        String sql = "select "
                +String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,SSN,EMAIL,PROFILE,PHONE)+
                " from "+TABLE_NAME+";";
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        do{
            MemberBean bean = new MemberBean();
            bean.setId(cursor.getString(0));
            bean.setPw(cursor.getString(1));
            bean.setName(cursor.getString(2));
            bean.setSsn(cursor.getString(3));
            bean.setEmail(cursor.getString(4));
            bean.setProfile(cursor.getString(5));
            bean.setPhone(cursor.getString(6));
            list.add(bean);
        }while(cursor.moveToNext());
        return list;
    }
    public MemberBean findById(String pk) {
        String sql = "select "
                +String.format(" %s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,SSN,EMAIL,PROFILE,PHONE)
                +String.format(" from "+TABLE_NAME+" where id = '%s';",pk);
        MemberBean temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()){
            temp = new MemberBean();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setSsn(cursor.getString(3));
            temp.setEmail(cursor.getString(4));
            temp.setProfile(cursor.getString(5));
            temp.setPhone(cursor.getString(6));
        }
        return temp;
    }
    public List<?> findByName(String name) {
        String sql = "select * from member where name = ?";
        List<MemberBean> list2 = new ArrayList<MemberBean>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return list2;
    }
    public int count() {
        int count = 0;
        String sql = "select count(*) as count from member";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return count;
    }
    public void delete(MemberBean mem) {
        String sql = "delete from member where id = ? and pw = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
    }
    public boolean login(MemberBean bean) {
        boolean loginOk= false;
        String sql = "select '"+PW+"' from "+TABLE_NAME
                +String.format(" where id = %s;",bean.getId());
        SQLiteDatabase db = this.getReadableDatabase();
        if(bean.getId()!=null && bean.getPw()!=null && this.findById(bean.getId())!=null){
            MemberBean bean2 = this.findById(bean.getId());
            if(bean2.getPw().equals(bean.getPw())){
                loginOk = true;
            }
        }
        return loginOk;
    }
}
