package com.li3huo.mybatisplus.demo.controller.response;

import java.util.List;
import com.li3huo.mybatisplus.demo.entity.Checklist;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * CheckinResponse
 */
@Data
@Accessors(chain = true)
public class CheckinResponse {
  private int code;
  private String msg;
  private List<Checklist> list;
}