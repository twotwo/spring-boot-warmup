package com.li3huo.mybatisplus.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li3huo.mybatisplus.demo.entity.ExamItem;
import com.li3huo.mybatisplus.demo.entity.ExamOrder;
import com.li3huo.mybatisplus.demo.entity.OrderItem;
import com.li3huo.mybatisplus.demo.entity.enums.OrderState;
import com.li3huo.mybatisplus.demo.mapper.ExamItemMapper;
import com.li3huo.mybatisplus.demo.mapper.ExamOrderMapper;
import com.li3huo.mybatisplus.demo.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * ExamService
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "ExamItemsCache")
public class ExamService {
  @Autowired
  private ExamItemMapper itemMapper;

  @Autowired
  private ExamOrderMapper orderMapper;

  @Autowired
  private OrderItemMapper orderItemMapper;

  @Cacheable
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
    // add ExamOrders to DB
    if(order.getId()>0) {
      for(ExamItem item: items) {
        orderItemMapper.insert(new OrderItem().setOrderId(order.getId())
          .setItemId(item.getId()));
      }
    }
    // orderCounter.increment();
    ExamOrder newOrder = getOrderbyId(order.getId());
    log.info("New Order: {}", newOrder);
    return newOrder;
  }

  public ExamOrder getOrderbyId(Long id) {
    ExamOrder order = orderMapper.selectById(id);
    // load ExamItems
    List<OrderItem> orderItems = orderItemMapper.selectList(new QueryWrapper<OrderItem>().lambda().eq(OrderItem::getOrderId, id));
    log.info("orderItems() {}",orderItems);
    order.setItems(itemMapper.selectBatchIds(orderItems.stream().map(OrderItem :: getItemId).collect(Collectors.toList())));
    return order;
  }

  private Long calcTotal(ExamItem...item) {
    List<Long> items = Stream.of(item).map(c -> c.getPrice())
            .collect(Collectors.toList());
    return items.stream().collect(Collectors.summingLong(Long :: longValue));
  }
  
}