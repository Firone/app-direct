package com.appdirect.demo.repository;

import com.appdirect.demo.model.OrderEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryOrderEventRepository implements OrderEventRepository {

    private static final List<OrderEvent> orderEvents = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void save(OrderEvent orderEvent) {
        orderEvents.add(orderEvent);
    }

    @Override
    public List<OrderEvent> findAll() {
        return Collections.unmodifiableList(orderEvents);
    }
}
