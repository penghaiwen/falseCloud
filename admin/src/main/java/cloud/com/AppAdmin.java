package cloud.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"cloud.com.**"})
@EnableDiscoveryClient
public class AppAdmin {
    public static void main(String[] args) {
        SpringApplication.run(AppAdmin.class);
    }
}
