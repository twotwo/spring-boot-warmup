package sb.warmup.neo4j;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.AuthTokens;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleNeo4jApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

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

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleNeo4jApplication.class, args);
	}

}