package sb.warmup.redis.service;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// import static org.assertj.core.api.Assertions.assertThat;

import sb.warmup.redis.domain.Customer;
import sb.warmup.redis.service.CustomerService;

/**
 * CustomerServiceTests
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CustomerServiceTests {

  @Autowired
  private CustomerService service;

  /**
   * mvn test -Dtest=CustomerServiceTests
   */
  @Test
  public void testCache() {
    log.debug("service={}", service);
    Customer customer = service.findCustomerByName("abc");
    log.debug("customer={}", customer);

  }
}