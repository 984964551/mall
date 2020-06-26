package wac.mall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Product;

import java.util.List;

@Repository
public interface ProductDao {
    //根据商品id更新商品的库存和销售数量
    @Update("update product set inventory=#{inventory},sales_volume=#{sales_volume} where id=#{id}")
    public void updatenumber(@Param("id")Integer id,@Param("inventory")Integer inventory,@Param("sales_volume") Integer sales_volume);

    //根据商品id查询商品
    @Select("select * from product where id=#{id}")
    public Product findbyid(Integer id);


    //根据商品的分类id和商品名联合查询商品列表
    @Select("<script>"
            +"select * from product where 1=1"
            +"<if test='cateid!=null'> and cate_id=#{cateid} </if>"
            +"</script>")
    public List<Product> findbycid(@Param("cateid")int cateid);//dao层2个及以上参数需要引入@Param

    //根据商品的分类id和商品名联合查询商品数量
    @Select("<script>"
            +"select count(*) from product where 1=1"
            +"<if test='cateid!=null'> and cate_id=#{cateid} </if>"
            +"</script>")
    public long findtotalcount(@Param("cateid")int cateid);

    //根据商品的分类id查询商品列表
    @Select("select * from product where cate_id=#{id}")
    public List<Product> findbycateid(Integer id);

    //保存插入的商品的信息
    @Insert("insert into product values(null,#{name},#{cate_id},#{thumbnail},#{inventory},#{sales_volume},#{price},#{sale_price},#{detail_description},null,#{create_time},#{sale_time})")
    public void save(Product product);

    //根据商品名查询商品列表
    @Select("<script>"
            +"select * from product where 1=1"
            +"<if test='name!=null'> and name like concat('%',#{name},'%')</if>"
            +"</script>")
    public List<Product> findbyname(@Param("name")String name);

    //根据商品名查询商品数量
    @Select("<script>"
            +"select count(*) from product where 1=1"
            +"<if test='name!=null'> and name like concat('%',#{name},'%')</if>"
            +"</script>")
    public long findtotalcountbyname(@Param("name")String name);

}
