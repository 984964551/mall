package wac.mall.service;

import wac.mall.domain.Member;

public interface MemberService {

    public Member findbymobile(String monile);

    public void save(Member member);
}
