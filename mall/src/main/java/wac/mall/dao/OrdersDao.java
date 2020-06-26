package wac.mall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Orders;

import java.util.Date;

@Repository
public interface OrdersDao {
    //保存订单
    @Insert("insert into orders values(null,#{number},#{buyer_id},#{total_amount},#{total_price},#{payment_price},#{remark},#{contact},#{mobile},#{street},#{zipcode},#{create_time},#{payment_time},#{delivery_time},#{end_time},#{status})")
    public void add(Orders orders);

    //根绝订单编号查询订单id
    @Select("select id from orders where number=#{number}")
    public int findid(String number);

    //根绝订单编号查询购买用户id
    @Select("select buyer_id from orders where number=#{number}")
    public int findbuyerid(String number);

    //根据订单编号更新订单状态
    @Update("update orders set status=#{status} where number=#{ordernumber}")
    public void update(@Param("status") int status, @Param("ordernumber") String ordernumber);

    //保存支付的时间
    @Update("update orders set payment_time=#{paytime} where number=#{number}")
    public void savepaytime(@Param("paytime") Date paytime,@Param("number") String number);

}
