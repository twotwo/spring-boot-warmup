package sb.warmup.neo4j;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface CustomerRepository extends GraphRepository<Customer> {

	Customer findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

}