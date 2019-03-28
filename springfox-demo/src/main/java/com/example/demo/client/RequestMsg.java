package com.example.demo.client;

import java.util.Map;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response Msg
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RequestMsg", description = "通用请求报文")
public class RequestMsg {

  private String appId;
  @ApiModelProperty(required = true, value = "数据", name = "reqData",
      example = "{\"uid\": \"5bc24532e695e1063a8fa11a925dcd5b0f764b1fc3e9d00dda7dce49f86babdb\"}",
      dataType = "Map<String, Object>", allowEmptyValue = true)
  private Map<String, Object> reqData;

}
