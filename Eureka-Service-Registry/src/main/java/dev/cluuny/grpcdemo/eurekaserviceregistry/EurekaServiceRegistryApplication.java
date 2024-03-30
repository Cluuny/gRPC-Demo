package dev.cluuny.grpcdemo.eurekaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * This class defines a Eureka Server.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceRegistryApplication.class, args);
    }

}
