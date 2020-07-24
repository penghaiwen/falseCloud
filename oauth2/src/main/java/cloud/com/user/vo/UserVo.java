package cloud.com.user.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements UserDetails {

    /**
     * 继承属性
     */
    private String username;
    @JSONField(serialize = false)
    private String password;
    Collection<? extends GrantedAuthority> authorities = null;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
}
