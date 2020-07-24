package cloud.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    UserDetailsService userDetailsService;
    @Resource
    RedisConnectionFactory redisConnectionFactory;


    // 指定密码的加密方式
    @Bean
    PasswordEncoder passwordEncoder() {
        // 使用BCrypt强哈希函数加密方案（密钥迭代次数默认为10）
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //这个好比账号
                .withClient("pro")
                //.redirectUris("http://localhost:9200/oauth/token")
                //授权同意的类型
                .authorizedGrantTypes("password", "refresh_token")
                //有效时间
                .accessTokenValiditySeconds(60 * 60 * 30)
                .refreshTokenValiditySeconds(60 * 60 * 60)
                .resourceIds("rid")
                //作用域，范围
                .scopes("all")
                //密码
                .secret(new BCryptPasswordEncoder().encode("123"));

    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(new RedisTokenStore(redisConnectionFactory))
                //身份验证管理
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许客户端表单身份验证
        security.allowFormAuthenticationForClients();
    }
}
