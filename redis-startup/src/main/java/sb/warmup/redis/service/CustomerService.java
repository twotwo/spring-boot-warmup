package sb.warmup.redis.service;

import sb.warmup.redis.domain.Customer;
import sb.warmup.redis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomerService
 */
@Service
@Slf4j
public class CustomerService {
  @SuppressWarnings("rawtypes")
  @Autowired
  private RedisTemplate redisTemplate;

  @Autowired
	private StringRedisTemplate stringRedisTemplate;

  @SuppressWarnings("unchecked")
  public Customer findCustomerByName(String name) {
    // get customer from cache: name->id->object
    String keyName = "warmup:customer.name_" + name;
    String KeyID;
    Customer customer = null;
    ValueOperations<String, String> ops_ID = this.stringRedisTemplate.opsForValue();
    ValueOperations<String, Customer> customerOps = redisTemplate.opsForValue();
    if (this.stringRedisTemplate.hasKey(keyName)) {
      KeyID = ops_ID.get(keyName);
      log.debug("find name key: {}->{}", name, KeyID);
      if (this.redisTemplate.hasKey(KeyID)) {
        customer = customerOps.get(KeyID);
      }
		}
    
    log.debug("customer={}",customer);
    if(null == customer) {
      customer = new Customer();
      customer.setId(123);
      customer.setName(name);
      customer.setEmail(name+"@mybatis.org");
      customer.setPhone("1234567");
      customer.setDescription("description:"+name);
      //pretend load from db
      log.info("create customer in db... {}", customer);
      KeyID = "warmup:customer_" + customer.getId();
      // put to cache for 10 seconds
      ops_ID.set(keyName, KeyID, 10, TimeUnit.SECONDS);
      customerOps.set(KeyID, customer, 10, TimeUnit.SECONDS);
    }
    return customer;
  }

}