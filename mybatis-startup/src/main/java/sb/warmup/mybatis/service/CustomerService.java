package sb.warmup.mybatis.service;

import sb.warmup.mybatis.dao.CustomerDao;
import sb.warmup.mybatis.domain.Customer;
import sb.warmup.mybatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomerService
 */
@Service
@Slf4j
public class CustomerService {
  @Autowired
  private CustomerDao dao;

  public Customer findCustomerByName(String name) {
    Customer customer = dao.findByName(name);
    log.debug("customer={}",customer);
    if(null == customer) {
      customer = new Customer();
      customer.setName(name);
      customer.setEmail(name+"@mybatis.org");
      customer.setPhone("1234567");
      customer.setDescription("description:"+name);
      dao.insert(customer);
      log.info("create customer... {}", customer);
    }
    return customer;
  }

}