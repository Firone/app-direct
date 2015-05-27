package com.appdirect.demo.repository;

import com.appdirect.demo.model.OrderEvent;
import com.appdirect.demo.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

public class InMemoryOrderEventRepositoryTest {

    private OrderEventRepository repository = new InMemoryOrderEventRepository();

    @Before
    public void setUp() throws Exception {
        repository.removeAll();
    }

    @Test
    public void can_save_and_get_order() {

        //Given
        OrderEvent orderEvent = new OrderEvent();
        repository.save(orderEvent);

        //Execute
        List<OrderEvent> events = repository.findAll();

        //Assert
        assertThat(events, hasSize(1));
        assertThat(events.get(0), is(orderEvent));
    }

    @Test
    public void can_find_order_by_user_openId() {

        //Given
        givenOrderEventWIthUserOpenId("111");
        givenOrderEventWIthUserOpenId("222");
        OrderEvent wantedOrder1 = givenOrderEventWIthUserOpenId("333");
        OrderEvent wantedOrder2 = givenOrderEventWIthUserOpenId("333");

        //Execute
        List<OrderEvent> orders = repository.findByUserOpenId("333");

        //Assert
        assertThat(orders, containsInAnyOrder(wantedOrder1, wantedOrder2));
    }

    @Test
    public void when_no_matching_openId__return_empty_list() {

        List<OrderEvent> orders = repository.findByUserOpenId("");

        assertThat(orders, hasSize(0));
    }

    private OrderEvent givenOrderEventWIthUserOpenId(String userOpenId) {
        OrderEvent order = new OrderEvent() {{
            setUser(new User() {{
                setOpenId(userOpenId);
            }});
        }};
        repository.save(order);
        return order;
    }
}
