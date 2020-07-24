package cloud.com.sys.service;

import cloud.com.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;



public interface ISysUser extends IService<SysUser> {
    SysUser getUserByUsername(String userName);
}
