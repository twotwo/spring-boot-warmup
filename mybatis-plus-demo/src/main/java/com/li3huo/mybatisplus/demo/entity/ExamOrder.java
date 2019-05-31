package com.li3huo.mybatisplus.demo.entity;

import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.li3huo.mybatisplus.demo.entity.enums.OrderState;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ExamOrder
 */
@Data
@Accessors(chain = true)
@TableName("t_order")
public class ExamOrder extends BaseEntity {
  private String patient;
  @TableField(exist = false)
  private List<ExamItem> items;
  private Long total;
  private OrderState state;
  private Date createTime;
  private Date updateTime;
}