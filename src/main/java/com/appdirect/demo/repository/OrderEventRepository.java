package com.appdirect.demo.repository;

import com.appdirect.demo.model.OrderEvent;
import com.appdirect.demo.model.User;

import java.util.List;

public interface OrderEventRepository {

    void removeAll();

    void save(OrderEvent user);

    List<OrderEvent> findAll();

    List<OrderEvent> findByUserOpenId(String openId);
}
