package cloud.com.sys.controller;


import cloud.com.common.AppResult;
import cloud.com.common.Result;
import cloud.com.sys.entity.SysUser;
import cloud.com.sys.service.ISysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {


    @Resource
    private ISysUser sysUser;

    @GetMapping("get/order/{id}")
    public Result getOrderDetails(@PathVariable("id") Long id){
        System.out.println("调用admin服务");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("msg","成功");
        return AppResult.ok(map);
    }

    @GetMapping("get/user")
    public Result getOrderDetails( ){
        throw new RuntimeException("测试");

    }

    @GetMapping("/product/{id}")
    public Result getProduct(@PathVariable String id) {
        return AppResult.ok();
    }



}
