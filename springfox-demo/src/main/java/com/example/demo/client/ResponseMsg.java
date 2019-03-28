package com.example.demo.client;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Response Msg
 * 
 */
@Data
@Builder
@ApiModel(value = "ResponseMsg", description = "通用返回报文")
public class ResponseMsg {
  /**
   * <p>
   * 服务编号: 02 //后台
   * <p>
   * 预留编号: 000
   * <p>
   * 请求编号: 011//请求来源+接口类型 --来自中台的第一个请求
   * <p>
   * 状态码: 0000 //成功
   */
  @Builder.Default
  @JsonProperty(value = "CODE")
  @ApiModelProperty(required = true, value = "报文应答码", name = "CODE", example = "02-000-011-0000",
      notes = "服务编号-预留编号-请求编号-状态码")
  private String code = "02-000-011-0000";

  @Builder.Default
  @JsonProperty(value = "DATA")
  @ApiModelProperty(required = true, value = "报文数据体", name = "DATA", example = "XX请求处理成功",
      dataType = "List<ResponseData>", allowEmptyValue = true)
  private List<ResponseData> data = Lists.newArrayList();

  @JsonProperty(value = "MSG")
  @ApiModelProperty(required = true, value = "报文消息", name = "MSG", example = "XX请求处理成功")
  private String msg;
}
