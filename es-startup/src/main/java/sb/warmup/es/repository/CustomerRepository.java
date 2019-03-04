package sb.warmup.es.repository;

import java.util.List;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import sb.warmup.es.models.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

	public Customer findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);

	@Query("select c from Customer c")
	public List<Customer> listCustomers(String name);

}