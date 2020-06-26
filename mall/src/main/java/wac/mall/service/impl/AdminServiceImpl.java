package wac.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.dao.AdminDao;
import wac.mall.domain.Admins;
import wac.mall.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public Admins findbyname(String username,String pwd) {
        return adminDao.findbyname(username,pwd);
    }
}
