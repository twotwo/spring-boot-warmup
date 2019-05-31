package com.li3huo.mybatisplus.demo.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * OrderState
 */
public enum OrderState {
  INIT(1, "初始化"), CANCELLED(2, "取消"), PAID(3, "已支付"), SUBSCRIBE(4, "已预约"), COMPLETE(5, "已完成");
  OrderState(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  @EnumValue
  private final int code;
  private final String desc;

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
