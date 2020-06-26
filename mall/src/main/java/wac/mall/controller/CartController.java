package wac.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.Result;
import wac.mall.domain.CartItem;
import wac.mall.domain.Member;
import wac.mall.domain.MemberCart;
import wac.mall.domain.Product;
import wac.mall.service.CartService;
import wac.mall.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @GetMapping("/delcart")
    @ResponseBody
    public Result addcart(Integer productid, HttpServletRequest req){
        Result result = new Result();
        Member member = (Member)req.getSession().getAttribute("member");
        MemberCart memberCart = new MemberCart(member.getId(), productid);
        cartService.delete(memberCart);
        Result result1 = new Result(true);
        return result;
    }

    @GetMapping("/addcart")
    @ResponseBody
    public Result addcart(Integer productid, Integer number, HttpServletRequest req){
        Result result = new Result();
        Member member = (Member)req.getSession().getAttribute("member");
        if (member!=null) {
            MemberCart memberCart = new MemberCart(member.getId(),productid,number);
            cartService.save(memberCart);
            result.setFlag(true);
            return result;
        }else {
            result.setFlag(false);
            return result;
        }
    }

    @GetMapping("/viewcart")
    @ResponseBody
    public Result viewcart(HttpServletRequest req){
        Result result = new Result();
        Member member = (Member)req.getSession().getAttribute("member");
        List<MemberCart> list=new ArrayList<>();
        if (member!=null) {
            list = cartService.findbymemberid(member.getId());
        }
        if (list.size()==0 || member==null ){
            result.setFlag(false);
            result.setMsg("您当前的购物车为空，快去购物吧！");
        }else {
            ArrayList<CartItem> cart = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Product product = productService.findbyid(list.get(i).getProductid());
                Integer pronumber=list.get(i).getPronumber();
                CartItem cartItem = new CartItem(product, pronumber);
                cart.add(cartItem);
            }
            result.setFlag(true);
            result.setData(cart);
        }
        return result;
    }
}
