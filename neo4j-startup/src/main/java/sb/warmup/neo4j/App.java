package sb.warmup.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import sb.warmup.neo4j.domain.Customer;
import sb.warmup.neo4j.domain.QueryConfig;
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
		System.out.println("found with printPeople():");
		System.out.println("-------------------------------");
		example.printPeople("A");
		example.close();
		// close connection
		System.out.println("example.close()");
		System.out.println("--------------------------------");
	}

	@Autowired
	private CustomerRepository repository;

	@Autowired
  private QueryConfig myConfig;

	@Override
	public void run(String... args) throws Exception {
		log.info("myConfig={}",myConfig.getMap());
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Customer("Alice", "Smith"));
		this.repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByName("Smith")) {
			System.out.println(customer);
		}
	}

	public static void main(String[] args) throws Exception {
		// SpringApplication.runSmallExample(SampleNeo4jApplication.class, args);
		SpringApplication.run(App.class, args);
	}

}