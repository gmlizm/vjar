package com.aboo.vjar;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(TestApplication.class);

//	public static void main(String[] args) throws Exception {
//		SpringApplication app = new SpringApplication(TestApplication.class);
//		app.setAddCommandLineProperties(false);
//		app.setBannerMode(Banner.Mode.OFF);
//		ApplicationContext context = app.run(args);
//		logger.error("【{}】 started test at {}", context.getId(), new Date(context.getStartupDate()));
//	}

}
