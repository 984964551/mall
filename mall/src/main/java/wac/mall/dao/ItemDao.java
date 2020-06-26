package wac.mall.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Item;

import java.util.List;

@Repository
public interface ItemDao {

    //添加订单项
    @Insert("insert into item values(null,#{order_id},#{product_id},#{amount},#{total_price},#{payment_price})")
    public void add(Item item);

    //根据订单id查询订单项
    @Select("select * from item where order_id=#{order_id}")
    public List<Item> findbyorderid(Integer order_id);

}
