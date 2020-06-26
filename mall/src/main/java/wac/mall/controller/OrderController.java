package wac.mall.controller;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.Result;
import wac.mall.domain.*;
import wac.mall.service.AddressService;
import wac.mall.service.CategoryService;
import wac.mall.service.OrderService;
import wac.mall.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    ProductService productService;

    @Autowired
    AddressService addressService;

    @Autowired
    OrderService orderService;

    @GetMapping("/confirmorder")
    @ResponseBody
    public Result confirmorder(String ids,String amounts){
        String[] idss = ids.split(",");
        String[] amountss = amounts.split(",");
        ArrayList<CartItem> arrayList=new ArrayList<>();
        for (int i = 0; i < idss.length; i++) {
            String id=idss[i];
            String amount=amountss[i];
            Product product = productService.findbyid(Integer.parseInt(id));
            CartItem cartItem = new CartItem(product, Integer.parseInt(amount));
            arrayList.add(cartItem);
        }
        Result result = new Result(true,arrayList,"查询成功");
        return result;
    }

    @RequestMapping("/submitorder")
    @ResponseBody
    public Result submitorder(Integer[] ids, Integer[] amounts, String remark, String address_id) {
        Orders orders=new Orders();
        //设置备注
        orders.setRemark(remark);
        //根据地址id查询所有的地址信息设置保存到订单中
        Address address = addressService.findbyaddressid(Integer.parseInt(address_id));
        orders.setBuyer_id(address.getMbr_id());
        orders.setContact(address.getContact());
        orders.setMobile(address.getMobile());
        orders.setStreet(address.getStreet());
        orders.setZipcode(address.getZipcode());
        //设置订单编号
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = simpleDateFormat.format(new Date());
        orders.setNumber(format);
        //设置订单状态(  0：表示未付款，1：表示已付款  2：表示未发货  )
        orders.setStatus(0);
        //设置订单生效日期
        orders.setCreate_time(new Date());
        //设置订单的总数量，总价格，总的实际购买价格
        int totalAmout=0;   //总数量
        double totalPrice=0;  //总价格
        double totalPayPrice=0; //实际支付的总价格
        for (int i = 0; i < ids.length; i++) {
            Product product = productService.findbyid(ids[i]);
            int amount=amounts[i];
            totalAmout+=amount;
            totalPrice+=product.getPrice()*amount;
            totalPayPrice+=product.getSale_price()*amount;
        }
        orders.setTotal_amount(totalAmout);
        orders.setTotal_price(totalPrice);
        orders.setPayment_price(totalPayPrice);
        orderService.add(orders,ids ,amounts );
        Result result = new Result(true,orders,"订单生成成功!");
        return result;
    }
}
