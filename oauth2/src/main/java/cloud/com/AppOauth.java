package cloud.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication(scanBasePackages = {"cloud.com.**"})
@EnableDiscoveryClient
@EnableResourceServer
public class AppOauth {
    public static void main(String[] args) {
        SpringApplication.run(AppOauth.class);
    }
}
