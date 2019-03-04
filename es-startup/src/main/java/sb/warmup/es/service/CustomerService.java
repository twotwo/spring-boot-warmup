package sb.warmup.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import sb.warmup.es.models.Customer;
import sb.warmup.es.repository.CustomerRepository;

/**
 * CustomerService
 */
@Service
@Slf4j
public class CustomerService {

  @Autowired
  private CustomerRepository repository;
  
  public void saveCustomers() {
		this.repository.save(new Customer("Alice", "Smith"));
		this.repository.save(new Customer("Bob", "Smith"));
	}

	public void fetchAllCustomers() {
		log.debug("Customers found with findAll():");
		log.debug("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			log.debug(customer.toString());
		}
		log.debug("\n");
	}

	public void fetchIndividualCustomers() {
		log.debug("Customer found with findByFirstName('Alice'):");
		log.debug("--------------------------------");
		log.debug(this.repository.findByFirstName("Alice").toString());

		log.debug("Customers found with findByLastName('Smith'):");
		log.debug("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			log.debug(customer.toString());
		}
	}
}