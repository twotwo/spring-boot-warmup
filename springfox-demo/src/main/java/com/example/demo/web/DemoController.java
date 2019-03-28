package com.example.demo.web;

import com.example.demo.client.RequestMsg;
import com.example.demo.client.ResponseData;
import com.example.demo.client.ResponseMsg;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.extern.slf4j.Slf4j;

/**
 * DemoController
 */
@RestController
@Slf4j
public class DemoController {
  @GetMapping("/")
  String home() {
    return "Demo API";
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public String getUserById(@ApiParam(value = "用户ID", required = true,
      example = "12") @PathVariable(value = "id") String id) throws Exception {
    log.info("getUserById() id={}", id);

    return "getUserById, id=" + id;
  }

  @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
  public ResponseMsg query(@RequestBody(required = false) RequestMsg request) throws Exception {
    ResponseData data = ResponseData.builder().model("model").tdata(request).build();
    log.info("query(), request={}, data={}", request, data);
    return ResponseMsg.builder().data(Lists.newArrayList(data)).code("100").msg("ok").build();
  }

}
