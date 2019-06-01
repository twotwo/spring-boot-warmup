package com.li3huo.mybatisplus.demo.controller.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * NewOrderRequest
 */
@Getter
@Setter
@ToString
public class NewOrderRequest {
    private String patient;
    //Item Id
    private List<Integer> items;
}