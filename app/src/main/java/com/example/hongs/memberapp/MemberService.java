package com.example.hongs.memberapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongs on 2016-07-27.
 */
public interface MemberService {
    public String regist(MemberBean bean);
    public boolean login(MemberBean bean);
    public void update(MemberBean bean);
    public void delete(MemberBean bean);
    public MemberBean detail(String detail);
    public MemberBean findById(String id);
    public int count();
    public ArrayList<MemberBean> list();
    public List<?> findByName(String findName);
    public List<?> findBy(String keyword);
    public String myAccount();
}
