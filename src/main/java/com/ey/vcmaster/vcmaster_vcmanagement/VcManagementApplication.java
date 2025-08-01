package com.ey.vcmaster.vcmaster_vcmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ey.vcmaster.vcmaster_vcmanagement")
public class VcManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(VcManagementApplication.class, args);
    }
}
