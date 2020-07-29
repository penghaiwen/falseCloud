package cloud.com.api.controller.service;

import cloud.com.common.AppResult;
import cloud.com.common.Result;
import org.springframework.stereotype.Component;

@Component
public class UserFallBack implements UserService {

   public Result getUser(){
      return AppResult.err();
   }

}
