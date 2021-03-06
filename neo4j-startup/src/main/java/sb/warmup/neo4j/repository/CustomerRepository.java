package sb.warmup.neo4j.repository;

import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import sb.warmup.neo4j.domain.Customer;

public interface CustomerRepository extends GraphRepository<Customer> {

	Customer findByFirstName(String firstName);

  List<Customer> findByLastName(String lastName);
  
  @Query(value = "MATCH (n:Customer{lastName:{0}}) RETURN n LIMIT 25")
  List<Customer> findByName(String name);

}