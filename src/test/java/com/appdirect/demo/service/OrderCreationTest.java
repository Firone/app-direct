package com.appdirect.demo.service;

import com.appdirect.demo.model.OrderEvent;
import com.appdirect.demo.repository.OrderEventRepository;
import com.appdirect.demo.utils.OrderEventParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderCreationTest {

    @InjectMocks
    private OrderCreation orderCreation;
    @Mock
    private OrderEventParser parser;
    @Mock
    private OrderEventRepository orderEventRepository;

    @Test
    public void when_valid_url_event__save_event_in_repository() throws Exception {

        OrderEvent wantedOrderEvent = new OrderEvent();
        when(parser.parse(any(InputStream.class))).thenReturn(wantedOrderEvent);

        orderCreation.handle("http://test.com");

        verify(orderEventRepository).save(wantedOrderEvent);
    }

    @Test
    public void when_invalid_xml_file__dont_save_event_and_throws_exception() throws Exception {

        doThrow(IOException.class).when(parser).parse(any(InputStream.class));

        try {
            orderCreation.handle("http://test.com");
            fail("Must throws IOException");
        } catch (IOException e) {
        }

        verifyZeroInteractions(orderEventRepository);
    }

    @Test
    public void when_invalid_url__dont_save_event_and_throws_exception() throws Exception {

        try {
            orderCreation.handle("invalid url");
            fail("Must throws IOException");
        } catch (IOException e) {
        }

        verifyZeroInteractions(orderEventRepository);
    }
}