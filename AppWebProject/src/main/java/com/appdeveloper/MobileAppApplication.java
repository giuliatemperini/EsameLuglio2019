package com.appdeveloper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.app.service.AppService;
import com.app.service.Element;

@ComponentScan({ "com.app.controller", "com.app.service" })
@SpringBootApplication
public class MobileAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppApplication.class, args);

		// AppService.jsonDecode("http://data.europa.eu/euodp/data/api/3/action/package_show?id=yGVKnIzbkC2ZHpT6jQouDg");

		AppService.csvParse("dataset.csv");

		// String s = AppService.printElement();

	}
}