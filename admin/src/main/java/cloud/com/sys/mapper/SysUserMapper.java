package cloud.com.sys.mapper;


import cloud.com.sys.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface  SysUserMapper extends BaseMapper<SysUser> {

    /**
     * @return
     * @Author 老默
     * @Description
     * @Date 2020/4/29 10:41
     * @param: userName
     **/
    SysUser getUserByUsername(@Param("userName") String userName);
}
