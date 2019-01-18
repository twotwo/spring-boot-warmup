package sb.warmup.redis;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import sb.warmup.redis.domain.Customer;
import sb.warmup.redis.service.CustomerService;

@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner {

	@Autowired
	private StringRedisTemplate template;

	@Autowired
	private CustomerService service;

	@Override
	public void run(String... args) throws Exception {
		ValueOperations<String, String> ops = this.template.opsForValue();
		String key = "warmup:redis.test";
		if (!this.template.hasKey(key)) {
			ops.set(key, "foo");
		}
		log.debug("Found key {}={}", key, ops.get(key));

		Customer customer = service.findCustomerByName("abc");
		log.debug("customer={}", customer);
		//load from cache
		customer = service.findCustomerByName("abc");
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class).close();
	}

}