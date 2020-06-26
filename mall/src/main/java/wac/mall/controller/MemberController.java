package wac.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.Result;
import wac.mall.domain.Member;
import wac.mall.service.MemberService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String mobile, String pwd, HttpServletRequest request){
        Result result=new Result();
        Member member = memberService.findbymobile(mobile);
        if (mobile.equals(member.getMobile()) && pwd.equals(member.getPwd())) {
            request.getSession().setAttribute("member", member);
            result.setFlag(true);
            result.setMsg("登录成功");
        } else {
            result.setFlag(false);
            result.setMsg("登录失败");
        }
        return result;
    }

    @RequestMapping("/regist")
    @ResponseBody
    public Result regist(String mobile,String pwd,String checkcode,HttpServletRequest request){
        HttpSession session = request.getSession();
        String checkcodeServer = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        Result result=new Result();
       if (checkcode.equalsIgnoreCase(checkcodeServer)){
           Member member = memberService.findbymobile(mobile);
           Member registmember = new Member();
           if (member==null){
               registmember.setMobile(mobile);
               registmember.setPwd(pwd);
               memberService.save(registmember);
               result.setFlag(true);
               result.setMsg("注册成功");
           }else {
               result.setFlag(false);
               result.setMsg("该手机号已被注册");
           }
       }else {
           result.setFlag(false);
           result.setMsg("验证码错误");
       }
        return result;
    }

    @GetMapping("/logout")
    @ResponseBody
    public Result regist(HttpServletRequest request){
        request.getSession().removeAttribute("member");
        Result result = new Result();
        result.setFlag(true);
        return result;
    }

    @GetMapping("/membername")
    @ResponseBody
    public Result membername(HttpServletRequest request){
        Member member = (Member)request.getSession().getAttribute("member");
        Result result = new Result();
        result.setFlag(true);
        result.setMsg("");
        result.setData(member);
        return result;
    }
}
