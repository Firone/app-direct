package com.appdirect.demo.controller;

import com.appdirect.demo.service.OrderEventReceived;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class UIController {

    @Autowired
    private OrderEventReceived orderEventReceived;

    @RequestMapping
    public String showReceivedEvents(ModelMap modelMap) {

        modelMap.addAttribute("orderEvents", orderEventReceived.findAllOrderEvents());

        return "received-events";
    }
}
