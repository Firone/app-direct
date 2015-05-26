package com.appdirect.demo.repository;

import com.appdirect.demo.model.OrderEvent;

import java.util.List;

public interface OrderEventRepository {

    void save(OrderEvent user);

    List<OrderEvent> findAll();
}
