package wac.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Admins;

@Repository
public interface AdminDao {
    @Select("select * from admins where username=#{username} and password=#{pwd}")
    public Admins findbyname(@Param("username") String username,@Param("pwd") String pwd);
}
