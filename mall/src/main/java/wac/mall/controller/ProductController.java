package wac.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.PageBean;
import wac.mall.common.Result;
import wac.mall.domain.Product;
import wac.mall.service.ProductService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @ResponseBody
    @GetMapping("/findbyid")
    public Result findbyid(Integer productid){
        Product product = productService.findbyid(productid);
        Result result = new Result();
        result.setData(product);
        return result;
    }

    @ResponseBody
    @GetMapping("/findpage")
    public PageBean<Product> findpage(String cate_id, String currentpage){
        if (cate_id==null){
            cate_id="1";
        }
        if (currentpage==null){
            currentpage="1";
        }
        PageBean pb = productService.findbycid(Integer.parseInt(cate_id),Integer.parseInt(currentpage));
        return pb;
    }

    @ResponseBody
    @GetMapping("/findpagename")
    public PageBean<Product> findpagename(String name, String currentpage){
        if (currentpage==null){
            currentpage="1";
        }
        PageBean pb = productService.findbyname(name,Integer.parseInt(currentpage));
        return pb;
    }

    @ResponseBody
    @GetMapping("/findbycateid")
    public Result findall(Integer cateid){
        Result result = new Result();
        List<Product> list = productService.findbycateid(cateid);
        result.setData(list);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Product product){
        product.setSales_volume(0);
        product.setCreate_time(new Date());
        product.setSale_time(new Date());
        productService.save(product);
        Result result = new Result(true, "添加成功");
        return result;
    }
}
