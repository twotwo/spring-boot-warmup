package sb.warmup.es.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import sb.warmup.es.App;
import sb.warmup.es.models.Customer;

/**
 * CustomerRepositoryTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@Slf4j
public class CustomerRepositoryTest {
  @Autowired
  private CustomerRepository repository;

  @Before
  public void before() {
    // repository.deleteIndex(Customer.class);
    // repository.createIndex(Customer.class);
    // repository.putMapping(Customer.class);
    // repository.refresh(Customer.class, true);
  }

  /**
   * mvn test -Dtest=CustomerRepositoryTest#testFindAll
   */
  @Test
  public void testFindAll() {
    for (Customer customer : this.repository.findAll()) {
			log.debug("cusomer={}", customer);
		}
  }

}
