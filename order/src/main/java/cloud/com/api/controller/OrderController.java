package cloud.com.api.controller;

import cloud.com.api.controller.service.UserService;
import cloud.com.common.AppResult;
import cloud.com.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private UserService userService;

    @GetMapping("get/details/{id}")
    public Result getOrderDetails(@PathVariable("id") Long id){
        return userService.getUser();
    }


    @GetMapping("get/order/{id}")
    public Result<Integer> getOrder(@PathVariable("id") Long id){
        return AppResult.ok(12121212);
    }
}
