package com.li3huo.mybatisplus.demo.controller;

import java.util.List;
import com.li3huo.mybatisplus.demo.controller.request.NewOrderRequest;
import com.li3huo.mybatisplus.demo.entity.ExamItem;
import com.li3huo.mybatisplus.demo.entity.ExamOrder;
import com.li3huo.mybatisplus.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * BookingController
 */
@RestController
@RequestMapping("booking")
@Slf4j
public class BookingController {

  @Autowired
  private BookService service;

  @GetMapping(path = "/menu")
  public List<ExamItem> getAll() {
    return service.getAllExamItem();
  }

  @GetMapping("/{id}")
  public ExamItem getById(@PathVariable Long id) {
    ExamItem item = service.getExamItem(id);
    log.info("Item {}:", item);
    return item;
  }

  @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ExamOrder create(@RequestBody NewOrderRequest newOrder) {
    log.info("Receive new Order {}", newOrder);
    ExamItem[] items =
        service.getItemById(newOrder.getItems()).toArray(new ExamItem[] {});
    return service.createOrder(newOrder.getPatient(), items);
  }
}
