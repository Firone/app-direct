package com.appdirect.demo.service;

import com.appdirect.demo.model.OrderEvent;
import com.appdirect.demo.repository.OrderEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderEventReceived {

    @Autowired
    private OrderEventRepository repository;

    public List<OrderEvent> findAllOrderEvents() {

        return repository.findAll();
    }
}
