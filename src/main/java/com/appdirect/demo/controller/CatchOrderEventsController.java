package com.appdirect.demo.controller;

import com.appdirect.demo.service.OrderCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequestMapping(value = "/api")
public class CatchOrderEventsController {

    private static final Logger logger = LoggerFactory.getLogger(CatchOrderEventsController.class);

    @Autowired
    private OrderCreation orderCreation;

    @RequestMapping(method = RequestMethod.GET, value = "/create", produces = {APPLICATION_XML_VALUE})
    @ResponseBody
    public Response create(
            @RequestParam("eventUrl") String eventUrl,
            @RequestParam("token") String token) {

        logger.debug("Catch event for order creation for token [{}]", token);

        try {
            orderCreation.handle(eventUrl);
        } catch (Exception e) {
            new Response(false, "UNKNOWN_ERROR", null);
        }

        return new Response(true, null, null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String handleSecond(ModelMap modelMap) {
        return "welcome-page";
    }
}
