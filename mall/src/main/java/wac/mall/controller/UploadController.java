package wac.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wac.mall.common.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/uploadThumbnail")
    @ResponseBody
    public Result fileload(HttpServletRequest request, MultipartFile pic) throws Exception {
        //使用fileload组件上传 上传的位置
        String path=request.getSession().getServletContext().getRealPath("/img");
        //说明上传文件项  获取上传文件的名称
        String Filename=pic.getOriginalFilename();
        //把文件名称设置为唯一值
        String uuid= UUID.randomUUID().toString().replace("-","" );
        Filename=uuid+"-"+Filename;
        //完成文件上传
        pic.transferTo(new File(path,Filename));
        Result result = new Result(true,Filename,"成功");
        return result;
    }


    @RequestMapping(path = "/ckeditorupload")
    @ResponseBody
    public Map ckeditorupload(HttpServletRequest request, MultipartFile upload)throws IOException, ServletException {
        //使用fileload组件上传 上传的位置
        String path=request.getSession().getServletContext().getRealPath("/img");
        //说明上传文件项
        //获取上传文件的名称
        String Filename=upload.getOriginalFilename();
        //把文件名称设置为唯一值
        String uuid= UUID.randomUUID().toString().replace("-","" );
        Filename=uuid+"-"+Filename;
        //完成文件上传
        upload.transferTo(new File(path,Filename));
        //ckeditor返回时的数据格式({"uploaded":1,"url": 要回显图片路径})
        Map map = new HashMap();
        map.put("uploaded",1);
        map.put("url","/img/"+Filename);
        return map;
    }
}
