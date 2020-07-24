package cloud.com.config;

import cloud.com.user.mapper.SysUserMapper;
import cloud.com.user.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private SysUserMapper userMapper;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserVo user = userMapper.getUserByUsername(s);
        return user;
    }
}
