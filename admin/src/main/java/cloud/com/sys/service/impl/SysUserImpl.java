package cloud.com.sys.service.impl;

import cloud.com.sys.entity.SysUser;
import cloud.com.sys.mapper.SysUserMapper;
import cloud.com.sys.service.ISysUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUser {
    @Resource
    private SysUserMapper mapper;

    @Override
    public SysUser getUserByUsername(String userName) {

        return mapper.getUserByUsername(userName);
    }

}
