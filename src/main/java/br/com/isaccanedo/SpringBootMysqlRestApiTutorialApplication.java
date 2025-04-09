package br.com.isaccanedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.isaccanedo")
public class SpringBootMysqlRestApiTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlRestApiTutorialApplication.class, args);
	}

}
