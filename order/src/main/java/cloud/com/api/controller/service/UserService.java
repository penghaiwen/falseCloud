package cloud.com.api.controller.service;

import cloud.com.common.Result;
import cloud.com.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "serviceAdmin",configuration = {FeignConfiguration.class})
public interface UserService {

    @GetMapping("api/get/user")
    Result getUser();
}
