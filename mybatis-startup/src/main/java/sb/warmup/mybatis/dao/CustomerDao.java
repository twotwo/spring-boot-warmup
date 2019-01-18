package sb.warmup.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

  /**
   * 添加数据
   * 
   * @param customer
   */
  @Insert("INSERT INTO sb_customer(name,email,phone,description) VALUES(#{name}, #{email}, #{phone}, #{description})")
  void insert(Customer customer);

  /**
   * 更新数据
   * 
   * @param customer
   */
  @Update("UPDATE sb_customer SET email=#{email},phone=#{phone},description=#{description} WHERE id =#{id}")
  void update(Customer customer);

  /**
   * 删除数据
   * 
   * @param id
   */
  @Delete("DELETE FROM sb_customer WHERE id =#{id}")
  void delete(Long id);
}