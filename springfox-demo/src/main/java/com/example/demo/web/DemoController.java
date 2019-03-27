package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 */
@RestController
public class DemoController {
  @GetMapping("/")
  String home() {
    return "Demo API";
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public String getUserById(@PathVariable(value = "id") String id) throws Exception {
    return "getUserById, id=" + id;
  }

}
