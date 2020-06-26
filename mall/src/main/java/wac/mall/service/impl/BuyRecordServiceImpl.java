package wac.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.dao.BuyRecordDao;
import wac.mall.dao.ItemDao;
import wac.mall.dao.ProductDao;
import wac.mall.domain.CartItem;
import wac.mall.domain.Item;
import wac.mall.domain.Orders;
import wac.mall.domain.Product;
import wac.mall.service.BuyRecordService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BuyRecordServiceImpl implements BuyRecordService {
    @Autowired
    BuyRecordDao buyRecordDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ProductDao productDao;

    @Override
    public List record(Integer nunmberid) {
        List<Orders> ordersList = buyRecordDao.findidtime(nunmberid);
        List redcordlist=new ArrayList();
        for (int i = 0; i < ordersList.size(); i++) {
            //获取支付时间
            Date paymentTime = ordersList.get(i).getPayment_time();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String paytimme = sdf.format(paymentTime);
            //获取订单id
            Integer id = ordersList.get(i).getId();
            List<Item> itemList = itemDao.findbyorderid(id);
            for (int i1 = 0; i1 < itemList.size(); i1++) {
                Integer productid = itemList.get(i1).getProduct_id();
                Integer amount = itemList.get(i1).getAmount();
                Product product = productDao.findbyid(productid);
                product.setPaytime(paytimme);
                CartItem cartItem = new CartItem(product, amount);
                redcordlist.add(cartItem);
            }
        }
        return redcordlist;
    }
}
