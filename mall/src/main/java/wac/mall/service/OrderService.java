package wac.mall.service;

import wac.mall.domain.Orders;

import java.util.Date;

public interface OrderService {
    public void add(Orders order, Integer[] ids,Integer[] amounts);

    public void update(int status,String ordernumber);

    public int findid(String number);

    public int findbuyerid(String number);

    public void savepaytime(Date paytime,String number);
}
