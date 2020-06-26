package wac.mall.service;

import org.apache.ibatis.annotations.Param;
import wac.mall.common.PageBean;
import wac.mall.domain.Product;

import java.util.List;

public interface ProductService {
    public void updatenumber(Integer order_id);

    public Product findbyid(Integer id);

    public PageBean findbycid(int cateid,int currentpage);

    public List<Product> findbycateid(Integer id);

    public void save(Product product);

    public  PageBean findbyname(String name,int currentpage);

}
