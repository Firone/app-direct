package com.appdirect.demo.controller;

import com.appdirect.demo.model.User;
import com.appdirect.demo.service.OrderEventReceived;
import com.appdirect.demo.utils.UserParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class UIController {

    @Autowired
    private OrderEventReceived orderEventReceived;
    @Autowired
    private UserParser userParser;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String show(Model model, OpenIDAuthenticationToken authentication) {

        User user = userParser.parse(authentication);

        model.addAttribute("user", user);
        model.addAttribute("personalOrders", orderEventReceived.findByUserOpenId(user));
        model.addAttribute("globalOrders", orderEventReceived.findAll());

        return "home";
    }
}
