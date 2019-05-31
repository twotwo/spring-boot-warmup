package com.li3huo.mybatisplus.demo.entity;

import java.sql.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ExamItem
 */
@Data
@TableName("t_exam_item")
public class ExamItem extends BaseEntity{
  private String name;
  private String content;
  private Long price;
  private Date createTime;
  private Date updateTime;
}
