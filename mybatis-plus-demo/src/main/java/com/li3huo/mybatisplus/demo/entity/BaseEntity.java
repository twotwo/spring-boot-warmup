
package com.li3huo.mybatisplus.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BaseEntity {
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
}