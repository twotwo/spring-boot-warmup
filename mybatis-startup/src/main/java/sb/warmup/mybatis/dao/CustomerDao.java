package sb.warmup.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import sb.warmup.mybatis.domain.Customer;

/**
 * CustomerDao
 */
public interface CustomerDao {
  @Select("SELECT * FROM sb_customer")
  @Results({ @Result(property = "name", column = "name") })
  List<Customer> getAll();
  @Select("SELECT * FROM sb_customer WHERE name = #{name}") 
  Customer findByName(@Param("name") String name);
  @Insert("INSERT INTO sb_customer(name,email,phone,description) VALUES(#{name}, #{email}, #{phone}, #{description})") 
  void insert(Customer customer);
}