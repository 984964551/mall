package wac.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.dao.MemberDao;
import wac.mall.domain.Member;
import wac.mall.service.MemberService;

import java.util.Date;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;

    @Override
    public Member findbymobile(String monile) {
        return memberDao.findbymobile(monile);
    }

    @Override
    public void save(Member member) {
        member.setRegister_time(new Date());
        memberDao.save(member);
    }
}
