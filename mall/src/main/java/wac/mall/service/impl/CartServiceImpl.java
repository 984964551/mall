package wac.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.dao.CartDao;
import wac.mall.dao.OrdersDao;
import wac.mall.dao.ProductDao;
import wac.mall.domain.Item;
import wac.mall.domain.MemberCart;
import wac.mall.domain.Orders;
import wac.mall.domain.Product;
import wac.mall.service.CartService;
import wac.mall.service.ItemService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;

    @Autowired
    ItemService itemService;

    @Autowired
    ProductDao productDao;

    @Override
    public void updel(Integer memberid,Integer orderid){
        List<Item> itemList = itemService.findbyorderid(orderid);
        for (int i = 0; i < itemList.size(); i++) {
            int productid=itemList.get(i).getProduct_id();
            int amount=itemList.get(i).getAmount();
            Product product = productDao.findbyid(productid);
            int pronumber=cartDao.findpronumber(memberid,productid);
            int finalnumber=pronumber-amount;
            MemberCart cart = cartDao.findcart(memberid, productid);
            cart.setPronumber(finalnumber);
            if (finalnumber!=0){
                cartDao.updatenumber(cart );
            }else {
                cartDao.delete(cart);
            }
        }
    }

    @Override
    public List findbymemberid(Integer memberid) {
        return cartDao.findbymemberid(memberid);
    }

    @Override
    public void delete(MemberCart memberCart) {
        cartDao.delete(memberCart);
    }

    @Override
    public void save(MemberCart memberCart) {
        List<MemberCart> list = cartDao.findbymemberid(memberCart.getMemberid());
        int addnumber=memberCart.getPronumber();
        int savenumber=addnumber;
        for (int i = 0; i < list.size(); i++) {
            if (memberCart.getProductid()==list.get(i).getProductid()){
                savenumber=memberCart.getPronumber()+list.get(i).getPronumber();
            }
        }
        if (savenumber!=addnumber){
            memberCart.setPronumber(savenumber);
            cartDao.updatenumber(memberCart);
        }else {
            cartDao.save(memberCart);
        }
    }
}
