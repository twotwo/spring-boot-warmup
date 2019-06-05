package com.li3huo.mybatisplus.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li3huo.mybatisplus.demo.controller.response.CheckinResponse;
import com.li3huo.mybatisplus.demo.entity.Checklist;
import com.li3huo.mybatisplus.demo.entity.ExamItem;
import com.li3huo.mybatisplus.demo.entity.ExamOrder;
import com.li3huo.mybatisplus.demo.entity.OrderItem;
import com.li3huo.mybatisplus.demo.entity.enums.OrderState;
import com.li3huo.mybatisplus.demo.mapper.ChecklistMapper;
import com.li3huo.mybatisplus.demo.mapper.ExamItemMapper;
import com.li3huo.mybatisplus.demo.mapper.ExamOrderMapper;
import com.li3huo.mybatisplus.demo.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

  @Autowired
  private ChecklistMapper checklistMapper;

  @Value("${exam.doctor}")
	private String doctor;

  public List<ExamItem> getItemById(List<Integer> idList) {
    List<ExamItem> items = itemMapper.selectBatchIds(idList);
    log.info("items: {}", items);
    return items;
  }

  public CheckinResponse checkin(long orderId) {
    CheckinResponse response = new CheckinResponse();
    ExamOrder order = orderMapper.selectById(orderId);
    log.debug("checkin() find order {}", order);
    if (null == order) {
      response.setCode(100).setMsg("invalid order!");
      return response;
    }
    // load ExamItems
    List<OrderItem> orderItems = orderItemMapper
        .selectList(new QueryWrapper<OrderItem>().lambda().eq(OrderItem::getOrderId, orderId));
    log.debug("checkin() load orderItems {}", orderItems);
    order.setItems(itemMapper.selectBatchIds(
        orderItems.stream().map(OrderItem::getItemId).collect(Collectors.toList())));

    // order ok, then load Checklists, if not exist, then create
    return response.setList(loadChecklistbyOrder(order)).setMsg("pls do exam as the checklist");
  }

  private List<Checklist> loadChecklistbyOrder(ExamOrder order) {

    List<Checklist> list = checklistMapper.selectList(
        new QueryWrapper<Checklist>().lambda().eq(Checklist::getOrderId, order.getId()));

    if (list.size() > 0) {
      return list;
    }

    // add Checklist to DB
    for (ExamItem item : order.getItems()) {
      Checklist checklist = new Checklist().setOrderId(order.getId()).setDoctor(doctor).setItemId(item.getId())
          .setState(OrderState.INIT);
      checklistMapper.insert(checklist);
    }
    return checklistMapper.selectList(
        new QueryWrapper<Checklist>().lambda().eq(Checklist::getOrderId, order.getId()));
  }

  public ExamOrder getOrderbyId(Long id) {
    ExamOrder order = orderMapper.selectById(id);
    // load ExamItems
    List<OrderItem> orderItems = orderItemMapper
        .selectList(new QueryWrapper<OrderItem>().lambda().eq(OrderItem::getOrderId, id));
    log.info("orderItems() {}", orderItems);
    order.setItems(itemMapper.selectBatchIds(
        orderItems.stream().map(OrderItem::getItemId).collect(Collectors.toList())));
    return order;
  }

}
