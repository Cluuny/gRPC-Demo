package dev.cluuny.grpcdemo.grpcdemoclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Defining the DiscoveryClient to provide connection to the Eureka Server.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GRpcDemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GRpcDemoClientApplication.class, args);
    }

}
