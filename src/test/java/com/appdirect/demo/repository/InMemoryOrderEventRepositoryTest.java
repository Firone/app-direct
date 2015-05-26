package com.appdirect.demo.repository;

import com.appdirect.demo.model.OrderEvent;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

public class InMemoryOrderEventRepositoryTest {

    private OrderEventRepository repository = new InMemoryOrderEventRepository();

    @Test
    public void can_save_and_get_user() {

        //Given
        OrderEvent orderEvent = new OrderEvent();
        repository.save(orderEvent);

        //Execute
        List<OrderEvent> events = repository.findAll();

        //Assert
        assertThat(events, hasSize(1));
        assertThat(events.get(0), is(orderEvent));
    }
}
