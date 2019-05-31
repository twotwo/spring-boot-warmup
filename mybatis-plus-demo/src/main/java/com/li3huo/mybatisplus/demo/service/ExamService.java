package com.li3huo.mybatisplus.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.li3huo.mybatisplus.demo.entity.ExamItem;
import com.li3huo.mybatisplus.demo.entity.ExamOrder;
import com.li3huo.mybatisplus.demo.entity.OrderItem;
import com.li3huo.mybatisplus.demo.entity.enums.OrderState;
import com.li3huo.mybatisplus.demo.mapper.ExamItemMapper;
import com.li3huo.mybatisplus.demo.mapper.ExamOrderMapper;
import com.li3huo.mybatisplus.demo.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * ExamService
 */
@Service
@Slf4j
public class ExamService {
  @Autowired
  private ExamItemMapper itemMapper;

  @Autowired
  private ExamOrderMapper orderMapper;

  @Autowired
  private OrderItemMapper orderItemMapper;

  public List<ExamItem> getAllExamItem() {
    return itemMapper.selectList(null);
  }

  public ExamItem getExamItem(Long id) {
    return itemMapper.selectById(id);
  }

  public List<ExamItem> getItemById(List<Integer> idList) {
    List<ExamItem> items = itemMapper.selectBatchIds(idList);
    log.info("items: {}", items);
    return items;
  }

  public ExamOrder createOrder(String patient, ExamItem...items) {
    log.info("OrderState.INIT {}",OrderState.INIT);
    
    ExamOrder order = new ExamOrder().setPatient(patient)
            .setItems(new ArrayList<>(Arrays.asList(items)))
            .setTotal(calcTotal(items))
            .setState(OrderState.INIT);
    orderMapper.insert(order);
    log.info("New Order: {}", order);
    // add ExamOrders to DB
    if(order.getId()>0) {
      for(ExamItem item: items) {
        orderItemMapper.insert(new OrderItem().setOrderId(order.getId())
          .setItemId(item.getId()).setState(order.getState()));
      }
    }
    // orderCounter.increment();
    return order;
  }

  private Long calcTotal(ExamItem...item) {
    List<Long> items = Stream.of(item).map(c -> c.getPrice())
            .collect(Collectors.toList());
    return items.stream().collect(Collectors.summingLong(Long :: longValue));
  }
  
}