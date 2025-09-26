package com.nic.MultiModuleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	    "com.nic.MultiModuleProject",
	    "com.nic.ivrimpds",
	    "com.nic.onorcs"
	})
	public class MultiModuleProjectApplication {
	    public static void main(String[] args) {
	        SpringApplication.run(MultiModuleProjectApplication.class, args);
	    }
	}
