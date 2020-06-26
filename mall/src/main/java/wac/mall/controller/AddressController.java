package wac.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wac.mall.common.Result;
import wac.mall.domain.Address;
import wac.mall.domain.Member;
import wac.mall.service.AddressService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/findByMember")
    @ResponseBody
    public Result findByMember(Integer id){
        List<Address> addressList = addressService.findbyid(id);
        Result result = new Result();
        result.setData(addressList);
        return result;
    }

    @GetMapping("/saveaddress")
    @ResponseBody
    public Result saveaddress(Address address,HttpServletRequest req){
        Member member = (Member)req.getSession().getAttribute("member");
        Integer id = member.getId();
        address.setMbr_id(id);
        addressService.saveaddress(address);
        Result result = new Result(true,"添加成功");
        return result;
    }
}
