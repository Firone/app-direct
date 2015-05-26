package com.appdirect.demo.utils;

import com.appdirect.demo.model.OrderEvent;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class OrderEventParser {

    public OrderEvent parse(InputStream inputStream) throws IOException, JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(OrderEvent.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        InputStreamReader reader = new InputStreamReader(inputStream);
        return (OrderEvent) unmarshaller.unmarshal(reader);
    }
}
