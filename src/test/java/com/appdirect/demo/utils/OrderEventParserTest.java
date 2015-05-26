package com.appdirect.demo.utils;

import com.appdirect.demo.model.OrderEvent;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderEventParserTest {

    private OrderEventParser parser = new OrderEventParser();

    @Test
    public void can_parse_order() throws IOException, JAXBException {

        InputStream fileReader = new FileInputStream(new File("./src/test/resources/dummyOrder.xml"));

        OrderEvent orderEvent = parser.parse(fileReader);

        assertThat(orderEvent.getUser().getEmail(), is("test-email+creator@appdirect.com"));
        assertThat(orderEvent.getUser().getFirstName(), is("DummyCreatorFirst"));
        assertThat(orderEvent.getPayload().getOrder().getEditionCode(), is("BASIC"));
    }
}