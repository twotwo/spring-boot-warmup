package com.example.demo.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Response Data in Resonse Msg
 * 
 */
@Data
@Builder
@ApiModel(value = "ResponseData", description = "通用返回报文数据体")
public class ResponseData {
  @JsonProperty(value = "MODEL")
  @ApiModelProperty(required = true, value = "数据类型", name = "model", example = "ResultModel")
  private String model;
  @JsonProperty(value = "SIZE")
  private int size;
  @JsonProperty(value = "TDATA")
  @ApiModelProperty(required = true, value = "数据", name = "tdata", allowEmptyValue = true)
  private Object tdata;
  @JsonProperty(value = "TOTALCOUNT")
  private int totalCount;
}
