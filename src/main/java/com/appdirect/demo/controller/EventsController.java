package com.appdirect.demo.controller;

import com.appdirect.demo.controller.dto.Response;
import com.appdirect.demo.service.OrderCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequestMapping(value = "/api")
public class EventsController {

    private static final Logger logger = LoggerFactory.getLogger(EventsController.class);

    @Autowired
    private OrderCreation orderCreation;

    @RequestMapping(method = RequestMethod.GET, value = "/create", produces = {APPLICATION_XML_VALUE})
    @ResponseBody
    public Response createOrder(
            @RequestParam("eventUrl") String eventUrl,
            @RequestParam("token") String token) {

        logger.debug("Catch event for order creation for token [{}]", token);

        try {
            orderCreation.handle(eventUrl);
        } catch (Exception e) {
            return invalidResponse();
        }

        return validResponse();
    }

    private Response invalidResponse() {
        return new Response(false, "UNKNOWN_ERROR", null);
    }

    private Response validResponse() {
        return new Response(true, null, null);
    }
}
