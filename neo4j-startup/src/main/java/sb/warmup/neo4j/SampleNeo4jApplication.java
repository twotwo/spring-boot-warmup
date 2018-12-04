package sb.warmup.neo4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleNeo4jApplication implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {


		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");


		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleNeo4jApplication.class, args);
	}

}