package sb.warmup.redis.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Customer
 */

@Data
public class Customer implements Serializable{
  private static final long serialVersionUID = 6779060835202379438L;
  private long id;
  private String name;
  private String email;
  private String phone;
  private String description;
  private Date create_at;
  private Date update_at;
}