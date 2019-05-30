package com.li3huo.mybatisplus.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * User
 */
@Data
@Accessors(chain = true)
@TableName("t_user")
public class User {
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  private String name;
  private Integer age;
  private String email;
}