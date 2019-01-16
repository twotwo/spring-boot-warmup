package sb.warmup.mybatis;

import org.mybatis.spring.annotation.MapperScan;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sb.warmup.mybatis.domain.Customer;
import sb.warmup.mybatis.service.CustomerService;

@SpringBootApplication
@MapperScan("sb.warmup.mybatis.dao")
@Slf4j
public class App implements CommandLineRunner {

	@Autowired
	private CustomerService service;

	@Override
	public void run(String... args) throws Exception {
		Customer customer = this.service.findCustomerByName("a");
		log.debug("customer={}",customer);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class).close();
	}

}