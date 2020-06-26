package wac.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.Result;
import wac.mall.domain.Member;
import wac.mall.service.BuyRecordService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/buy")
public class BuyRecordController {
    @Autowired
    BuyRecordService buyRecordService;

    @RequestMapping("/record")
    @ResponseBody
    public Result record(HttpServletRequest request){
        Member member = (Member)request.getSession().getAttribute("member");
        List list = buyRecordService.record(member.getId());
        Result result = new Result(true, list, "成功");
        return result;
    }
}
