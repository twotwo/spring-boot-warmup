package com.li3huo.mybatisplus.demo.controller;

import com.li3huo.mybatisplus.demo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * ExamController
 */
@RestController
@RequestMapping("exam")
@Slf4j
public class ExamController {

  @Autowired
  private ExamService service;

  @GetMapping(path = "/checkin", params = "id")
  public Object checkin(@RequestParam long id) {
    log.debug("checkin ...");
    return service.checkin(id);
  }
}