package com.li3huo.mybatisplus.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.li3huo.mybatisplus.demo.entity.enums.OrderState;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Checklist
 */
@Data
@Accessors(chain = true)
@TableName("t_checklist")
public class Checklist extends BaseEntity{
  @TableField("order_id")
  private Long orderId;
  @TableField("item_id")
  private Long itemId;
  private String doctor;
  private String record;
  private OrderState state;
}
