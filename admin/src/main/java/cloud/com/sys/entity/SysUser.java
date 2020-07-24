package cloud.com.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class SysUser {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String account;

    private String nickName;

    private String password;
}
