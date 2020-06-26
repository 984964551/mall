package wac.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.Result;
import wac.mall.domain.Admins;
import wac.mall.service.AdminService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String username,String adminpwd,HttpServletRequest request){
        Admins admin = (Admins) adminService.findbyname(username,adminpwd);
        Result result = new Result();
        if (admin!=null){
            request.getSession().setAttribute("admin",admin );
            result.setFlag(true);
            result.setData(admin);
            result.setMsg("登录成功");
        }else {
            result.setFlag(false);
            result.setMsg("登录失败");
        }
        return result;
    }

}
