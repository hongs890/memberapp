package com.example.hongs.memberapp;

import android.content.Context;
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
    public static final String PHONE = "phone";



    public MemberDAO(Context context) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "
                +TABLE_NAME
                +" ( "
                +ID+" text primary key, "
                +PW+" text, "
                +NAME+" text,"
                +SSN+" text,"
                +EMAIL+" text,"
                +PHONE+" text"
                +" ); "

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("");
    }
    public int insert(MemberBean mem) {
        int result = 0;
        String sql = "insert into member(id,pw,name,reg_date,ssn,email,profile_img,phone) "
                + "values(?,?,?,?,?,?,?,?)";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }

    public void update(MemberBean mem) {
        String sql = "update member set pw = ?, email = ? where id = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

    }

    public List<?> list() {
        String sql = "select * from member";
        List<MemberBean> list = new ArrayList<MemberBean>();
        SQLiteDatabase db = this.getReadableDatabase();
        return list;
    }

    public MemberBean findById(String pk) {
        String sql = "select * from member where id = ?";
        MemberBean temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        return temp;
    }


    public List<?> findByName(String name) {
        String sql = "select * from member where name = ?";
        List<MemberBean> list2 = new ArrayList<MemberBean>();
        SQLiteDatabase db = this.getReadableDatabase();

        return list2;
    }

    public int count() {
        int count = 0;
        String sql = "select count(*) as count from member";
        SQLiteDatabase db = this.getReadableDatabase();
        return count;
    }

    public void delete(MemberBean mem) {
        String sql = "delete from member where id = ? and pw = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public boolean login(MemberBean param) {
        boolean loginOk= false;
        String sql = "";
        if(param.getId()!=null
                && param.getPw()!=null
                && this.existId(param.getId())){
            MemberBean member = this.findById(param.getId());
            if(member.getPw().equals(param.getPw())){
                loginOk = true;
            }
            SQLiteDatabase db = this.getReadableDatabase();
            db.execSQL(sql);

        }
        return loginOk;
    }

    public boolean existId(String id){
        boolean existOK = false;
        String sql = "select count(*) as count from member where id = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        int result = 0;
        return existOK;
    }


}
