package wac.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.dao.ItemDao;
import wac.mall.domain.Item;
import wac.mall.service.ItemService;

import java.util.List;

@Service
public class ItrmServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> findbyorderid(Integer order_id) {
        return itemDao.findbyorderid(order_id);
    }

}
