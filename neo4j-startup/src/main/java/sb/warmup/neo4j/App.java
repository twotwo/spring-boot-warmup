package sb.warmup.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import sb.warmup.neo4j.domain.Customer;
import sb.warmup.neo4j.repository.CustomerRepository;

@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner {

	// @Override
	public void runSmallExample(String... args) throws Exception {

		SmallExample example = new SmallExample("bolt://localhost:7687", "neo4j", "secret");
		example.addPerson("Ada");
		example.addPerson("Alice");
		example.addPerson("Bob");
		log.debug("found with printPeople():");
		log.debug("-------------------------------");
		example.printPeople("A");
		example.close();
		// close connection
		log.debug("example.close()");
		log.debug("--------------------------------");
	}

	@Autowired
	private CustomerRepository repository;

	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Customer("Alice", "Smith"));
		this.repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		log.debug("Customers found with findAll():");
		log.debug("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			log.debug("customer={}", customer);
		}

		// fetch an individual customer
		log.debug("Customer found with findByFirstName('Alice'):");
		log.debug("--------------------------------");
		log.debug("Alice={}", this.repository.findByFirstName("Alice"));

		log.debug("Customers found with findByLastName('Smith'):");
		log.debug("--------------------------------");
		for (Customer customer : this.repository.findByName("Smith")) {
			log.debug("Smith={}", customer);
		}
	}

	public static void main(String[] args) throws Exception {
		// SpringApplication.runSmallExample(SampleNeo4jApplication.class, args);
		SpringApplication.run(App.class, args);
	}

}