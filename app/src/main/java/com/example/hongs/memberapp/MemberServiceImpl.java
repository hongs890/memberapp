package com.example.hongs.memberapp;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongs on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService {

    private MemberDAO dao;
    MemberBean session;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public String regist(MemberBean mem) {
       String msg = "";
        int result = dao.insert(mem);
        if (result == 0) {
            Log.d("DAO를 다녀옴",String.valueOf(result));
        }else{
            Log.d("DAO를 다녀오지 않음",String.valueOf(result));
        }
        return msg;
    }

    @Override
    public boolean login(MemberBean bean) {
        return dao.login(bean);
    }

    @Override
    public void update(MemberBean mem) {
        mem.setId(session.getId());
        dao.update(mem);
        session = dao.findById(mem.getId());
    }
    @Override
    public void delete(MemberBean mem) {
        dao.delete(mem);
        session = dao.findById(mem.getId());
    }
    @Override
    public int count() {
        return dao.count();
    }
    @Override
    public MemberBean detail(String mem) {
        return dao.findById(mem);
    }

    @Override
    public MemberBean findById(String id) {
        return dao.findById(id);
    }

    @Override
    public ArrayList<MemberBean> list() {
        return dao.list();
    }
    @Override
    public List<?> findByName(String findName) {
        return dao.findByName(findName);
    }
    @Override
    public List<?> findBy(String keyword) {
        return null;
    }
    @Override
    public String myAccount() {
        return session.toString();
    }
}
