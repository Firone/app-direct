package com.appdirect.demo.service;

import com.appdirect.demo.model.OrderEvent;
import com.appdirect.demo.repository.OrderEventRepository;
import com.appdirect.demo.utils.OrderEventParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component
public class OrderCreation {

    @Autowired
    private OrderEventParser parser;
    @Autowired
    private OrderEventRepository orderEventRepository;

    public void handle(String orderCreationEventUrl) throws IOException, JAXBException {

        URL url = new URL(orderCreationEventUrl) ;
        try (InputStream inputStream = url.openStream()) {

            OrderEvent orderEvent = parser.parse(inputStream);
            orderEventRepository.save(orderEvent);
        }
    }
}
