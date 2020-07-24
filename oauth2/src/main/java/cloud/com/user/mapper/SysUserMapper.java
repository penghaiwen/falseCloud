package cloud.com.user.mapper;
import cloud.com.user.vo.UserVo;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper  {

    /**
     * @return
     * @Author 老默
     * @Description
     * @Date 2020/4/29 10:41
     * @param: userName
     **/
    UserVo getUserByUsername(@Param("userName") String userName);
}
