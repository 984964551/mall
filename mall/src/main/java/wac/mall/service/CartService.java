package wac.mall.service;

import wac.mall.domain.MemberCart;

import java.util.List;

public interface CartService {

    public void updel(Integer memberid,Integer orderid);

    public void save(MemberCart memberCart);

    public List findbymemberid(Integer memberid);

    public void delete(MemberCart memberCart);
}
