package sb.warmup.mybatis.domain;

import java.util.Date;

import lombok.Data;

/**
 * Customer
 */

@Data
public class Customer {
  private long id;
  private String name;
  private String email;
  private String phone;
  private String description;
  private Date create_at;
  private Date update_at;
}