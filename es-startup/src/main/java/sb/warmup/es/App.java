package sb.warmup.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sb.warmup.es.models.Customer;
import sb.warmup.es.repository.CustomerRepository;
import sb.warmup.es.service.CustomerService;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private CustomerService service;

	@Override
	public void run(String... args) throws Exception {
		// this.repository.deleteAll();
		// saveCustomers();
		// fetchAllCustomers();
		// fetchIndividualCustomers();
		service.fetchAllCustomers();
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

}