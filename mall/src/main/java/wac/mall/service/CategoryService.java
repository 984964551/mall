package wac.mall.service;

import wac.mall.domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findall();

    public String findCategorybyredis();
}
