package sb.warmup.es;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

	public Customer findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);

}