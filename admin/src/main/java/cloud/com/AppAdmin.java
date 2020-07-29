package cloud.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

@SpringBootApplication(scanBasePackages = {"cloud.com.**"})
@EnableDiscoveryClient
public class AppAdmin {
    public static void main(String[] args) {
        SpringApplication.run(AppAdmin.class);
    }
}
