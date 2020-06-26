package wac.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.common.PageBean;
import wac.mall.dao.ProductDao;
import wac.mall.domain.Item;
import wac.mall.domain.Product;
import wac.mall.service.ItemService;
import wac.mall.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    ItemService itemService;

    @Override
    public void updatenumber(Integer order_id) {
        List<Item> itemList = itemService.findbyorderid(order_id);
        for (int i = 0; i < itemList.size(); i++) {
            int productid=itemList.get(i).getProduct_id();
            int amount=itemList.get(i).getAmount();
            Product product = productDao.findbyid(productid);
            int inventory=product.getInventory()-amount;
            int salesvolume=product.getSales_volume()+amount;
            productDao.updatenumber(productid,inventory ,salesvolume );
        }
    }

    @Override
    public Product findbyid(Integer id) {
        return productDao.findbyid(id);
    }

    @Override
    public PageBean findbycid(int cateid,int currentpage) {
        PageBean<Product> pb = new PageBean<>();
        //设置每页显示的商品数量
        long pagesize=10;
        pb.setPageSize(pagesize);
        //分页查询出的商品
        PageHelper.startPage(currentpage, (int) pagesize);
        List<Product> productList = productDao.findbycid(cateid);
        pb.setList(productList);
        //根据名字查询商品总数量
        long totalcount = productDao.findtotalcount(cateid);
        pb.setTotalCount(totalcount);
        //计算总页码
        long totalpage=(totalcount%pagesize) == 0 ? (totalcount/pagesize) : (totalcount/pagesize)+1;
        pb.setTotalPage(totalpage);
        pb.setCurrentPage(currentpage);
        return pb;
    }

    @Override
    public List<Product> findbycateid(Integer id) {
        return productDao.findbycateid(id);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public PageBean findbyname(String name, int currentpage) {
        PageBean<Product> pb = new PageBean<>();
        //设置每页显示的商品数量
        long pagesize=10;
        pb.setPageSize(pagesize);
        //分页查询出的商品
        PageHelper.startPage(currentpage, (int) pagesize);
        List<Product> productList = productDao.findbyname(name);
        pb.setList(productList);
        //根据名字查询商品总数量
        long totalcount = productDao.findtotalcountbyname(name);
        pb.setTotalCount(totalcount);
        //计算总页码
        long totalpage=(totalcount%pagesize) == 0 ? (totalcount/pagesize) : (totalcount/pagesize)+1;
        pb.setTotalPage(totalpage);
        pb.setCurrentPage(currentpage);
        return pb;
    }

}
