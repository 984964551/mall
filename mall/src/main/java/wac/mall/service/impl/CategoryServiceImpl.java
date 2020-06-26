package wac.mall.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wac.mall.dao.CategoryDao;
import wac.mall.domain.Category;
import wac.mall.service.CategoryService;
import wac.mall.utils.JedisUtil;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public String findCategorybyredis(){
        Jedis jedis= JedisUtil.getJedis();
        String category = jedis.get("Category");
        if (category==null){
            List list = categoryDao.findall();
            ObjectMapper objectMapper=new ObjectMapper();
            try {
                String json=objectMapper.writeValueAsString(list);
                jedis.set("Category",json );
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return category;
    }

    @Override
    public List<Category> findall() {
        return categoryDao.findall();
    }
}
