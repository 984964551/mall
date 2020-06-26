package wac.mall.dao;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import wac.mall.domain.MemberCart;

import java.util.List;

@Repository
public interface CartDao {
    //保存用户购物车
    @Insert("insert into membercart values(#{memberid},#{productid},#{pronumber})")
    public void save(MemberCart memberCart);

    //根据用户商品id更新购物车中商品的数量
    @Update("update membercart set pronumber=#{pronumber} where memberid=#{memberid} and productid=#{productid} ")
    public void updatenumber(MemberCart memberCart);

    //根据用户商品id查询购物车中商品的数量
    @Select("select pronumber from membercart where memberid=#{memberid} and productid=#{productid} ")
    public int findpronumber(@Param("memberid") Integer memberid,@Param("productid") Integer productid);

    @Select("select * from membercart where memberid=#{memberid} and productid=#{productid} ")
    public MemberCart findcart(@Param("memberid") Integer memberid,@Param("productid") Integer productid);

    //删除购物车中的商品
    @Delete("delete from membercart where memberid=#{memberid} and productid=#{productid} ")
    public void delete(MemberCart memberCart);

    //根据用户id查询用户商品中间表
    @Select("select * from membercart where memberid=#{memberid}")
    public List<MemberCart> findbymemberid(Integer memberid);

}
