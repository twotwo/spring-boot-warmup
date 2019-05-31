
package com.li3huo.mybatisplus.demo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class BaseEntity {
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
}
