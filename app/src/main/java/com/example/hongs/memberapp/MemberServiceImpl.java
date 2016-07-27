package com.example.hongs.memberapp;

import java.util.List;

/**
 * Created by hongs on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService {
    private MemberDAO dao = MemberDAO.getInstance();
    private MemberBean session;
    private static MemberServiceImpl instanceImpl = new MemberServiceImpl();
    private MemberServiceImpl() {
        session = new MemberBean();
    }
    public MemberBean getSession() {
        return session;
    }
    public void logoutSession(MemberBean member) {
        if (member.getId().equals(session.getId()) && member.getPw().equals(session.getPw())) {
            session = null;
        }
    }
    public static MemberServiceImpl getInstanceImpl() {
        return instanceImpl;
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
