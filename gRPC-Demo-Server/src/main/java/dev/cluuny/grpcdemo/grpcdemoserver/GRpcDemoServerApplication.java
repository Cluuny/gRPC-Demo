package dev.cluuny.grpcdemo.grpcdemoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Defining the DiscoveryClient to provide connection to the Eureka Server.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GRpcDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GRpcDemoServerApplication.class, args);
    }

}
