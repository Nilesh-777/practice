package com.app;

import static com.app.factory.Factory.logger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.TxrService;
import com.app.service.UPITxrService;

public class App {

	static UPITxrService txr;

	public static void main(String[] args) {
		logger.info("App started");

		ConfigurableApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("account-service.xml");

		txr = context.getBean("UPItxrService", UPITxrService.class);

		txr.transfer("2", "1", 2000.00);

		logger.info("App destroyed");

	}

}