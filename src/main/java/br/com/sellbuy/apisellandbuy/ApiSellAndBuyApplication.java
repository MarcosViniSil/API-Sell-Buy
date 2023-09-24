package br.com.sellbuy.apisellandbuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiSellAndBuyApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiSellAndBuyApplication.class, args);
	}

}
