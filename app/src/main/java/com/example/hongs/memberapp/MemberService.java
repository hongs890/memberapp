package com.example.hongs.memberapp;

import java.util.List;

/**
 * Created by hongs on 2016-07-27.
 */
public interface MemberService {
    public String regist(MemberBean mem);
    public void update(MemberBean mem);
    public void delete(MemberBean mem);
    public MemberBean detail(String mem);
    public int count();
    public List<?> list();
    public List<?> findByName(String findName);
    public List<?> findBy(String keyword);
    public String myAccount();
}
