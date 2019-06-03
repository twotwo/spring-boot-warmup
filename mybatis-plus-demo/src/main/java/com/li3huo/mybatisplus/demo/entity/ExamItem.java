package com.li3huo.mybatisplus.demo.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ExamItem
 */
@Data
@TableName("t_exam_item")
public class ExamItem extends BaseEntity implements Serializable{
  private static final long serialVersionUID = 3228454654692895298L;
  private String name;
  private String content;
  private Long price;
}
