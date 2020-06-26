package wac.mall.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Category;

import java.util.List;

@Repository
public interface CategoryDao {

    //查询所有的商品分类
    @Select("select * from category")
    public List<Category> findall();
}
