package wac.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.dao.ItemDao;
import wac.mall.dao.OrdersDao;
import wac.mall.dao.ProductDao;
import wac.mall.domain.Item;
import wac.mall.domain.Orders;
import wac.mall.domain.Product;
import wac.mall.service.OrderService;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersDao ordersDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ProductDao productDao;

    @Override
    public void add(Orders order, Integer[] ids,Integer[] amounts) {
        ordersDao.add(order);
        Item item = new Item();
        item.setOrder_id(ordersDao.findid(order.getNumber()));
        for (int i = 0; i < ids.length; i++) {
            item.setProduct_id(ids[i]);
            Product product = productDao.findbyid(ids[i]);
            item.setAmount(amounts[i]);
            item.setTotal_price(product.getPrice()*amounts[i]);
            item.setPayment_price(product.getSale_price()*amounts[i]);
            itemDao.add(item);
        }
    }

    @Override
    public void update(int status, String ordernumber) {
        ordersDao.update(status,ordernumber);
    }

    @Override
    public int findid(String number) {
        return ordersDao.findid(number);
    }

    @Override
    public int findbuyerid(String number) {
        return ordersDao.findbuyerid(number);
    }

    @Override
    public void savepaytime(Date paytime,String number){
        ordersDao.savepaytime(paytime,number );
    }
}
