package com.appdirect.demo.repository;

import com.appdirect.demo.model.OrderEvent;
import com.google.common.base.Predicate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

@Repository
public class InMemoryOrderEventRepository implements OrderEventRepository {

    private static final List<OrderEvent> orderEvents = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void removeAll() {
        orderEvents.clear();
    }

    @Override
    public void save(OrderEvent orderEvent) {
        orderEvents.add(orderEvent);
    }

    @Override
    public List<OrderEvent> findAll() {
        return Collections.unmodifiableList(orderEvents);
    }

    @Override
    public List<OrderEvent> findByUserOpenId(String openId) {

        if (openId == null)
            return emptyList();

        return newArrayList(filter(orderEvents, new Predicate<OrderEvent>() {
            @Override
            public boolean apply(OrderEvent orderEvent) {
                return openId.equals(orderEvent.getUser().getOpenId());
            }
        }));
    }
}
