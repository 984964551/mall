package wac.mall.service;

import wac.mall.domain.Admins;

public interface AdminService {
    public Admins findbyname(String username,String pwd);
}
