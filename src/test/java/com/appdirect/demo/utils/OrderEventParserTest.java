package com.appdirect.demo.utils;

import com.appdirect.demo.model.OrderEvent;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderEventParserTest {

    private OrderEventParser parser = new OrderEventParser();

    @Test
    public void can_parse_order() throws IOException, JAXBException {

        InputStream fileReader = new FileInputStream(new File("./src/test/resources/dummyOrder.xml"));

        OrderEvent orderEvent = parser.parse(fileReader);

        assertThat(orderEvent.getUser().getFirstName(), is("DummyCreatorFirst"));
        assertThat(orderEvent.getUser().getOpenId(), is("https://www.appdirect.com/openid/id/ec5d8eda-5cec-444d-9e30-125b6e4b67e2"));
        assertThat(orderEvent.getPayload().getOrder().getEditionCode(), is("BASIC"));
    }
}
