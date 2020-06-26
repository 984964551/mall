package wac.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.Result;
import wac.mall.domain.Category;
import wac.mall.service.CategoryService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/findall")
    @ResponseBody
    public String findall(HttpServletResponse resp){
        String categorybyredis = categoryService.findCategorybyredis();
        return categorybyredis;
    }
}
