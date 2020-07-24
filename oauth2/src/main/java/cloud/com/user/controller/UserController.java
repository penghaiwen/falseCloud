package cloud.com.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("oauth/user")
    public  Principal getPrincipal(Principal principal){
        System.out.println("开始执行");
        return principal;
    }
}
