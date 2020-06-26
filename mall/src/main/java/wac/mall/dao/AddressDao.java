package wac.mall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import wac.mall.domain.Address;

import java.util.List;

@Repository
public interface AddressDao {

    //根据用户id查询用户地址
    @Select("select * from address where mbr_id=#{id}")
    public List<Address> findbyid(Integer id);

    //保存用户地址
    @Insert("insert into address values(null,#{contact},#{mobile},#{street},#{zipcode},#{mbr_id},#{default_value})")
    public void saveaddress(Address address);

    //跟新用户的默认地址
    @Update("update address set default_value=0 where mbr_id=#{memberid}")
    public void updatevalue(Integer memberid);

    //根据地址id查询地址
    @Select("select * from address where id=#{id}")
    public Address findbyaddressid(Integer id);
}
