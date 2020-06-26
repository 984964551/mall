package wac.mall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Member;

@Repository
public interface MemberDao {

    //根据手机号查询用户
    @Select("select * from mall.member where mobile=#{mobile}")
    public Member findbymobile(String mobile);

    //保存用户
    @Insert("insert into mall.member values(null,#{mobile},#{pwd},null,null,null,null,#{register_time})")
    public void save(Member member);
}
