package com.example.hongs.memberapp;

import android.content.Context;

import java.util.List;

/**
 * Created by hongs on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService {

    MemberDAO dao;
    MemberBean session;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public String regist(MemberBean mem) {
        String msg = "";
        if (dao.insert(mem)==1) {
            msg = dao.findById(mem.getId()).getName();
        }
        return msg;
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
    public List<?> list() {
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
