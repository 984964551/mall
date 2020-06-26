package wac.mall.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Orders;

import java.util.List;

@Repository
public interface BuyRecordDao {
    //根据用户id查询所有的订单id和订单支付时间
    @Select("select id,payment_time from orders where buyer_id=#{memberid}")
    public List<Orders> findidtime(Integer memberid);
}
