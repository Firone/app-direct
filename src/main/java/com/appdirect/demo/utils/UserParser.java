package com.appdirect.demo.utils;

import com.appdirect.demo.model.User;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserParser {

    public User parse(OpenIDAuthenticationToken authentication) {

        User user = new User();
        user.setOpenId(authentication.getIdentityUrl());
        user.setFirstName(extractFirstName(authentication.getAttributes()));

        return user;
    }

    private String extractFirstName(List<OpenIDAttribute> attributes) {

        for (OpenIDAttribute attribute : attributes) {
            if (attribute.getName().equals("firstname"))
                return attribute.getValues().get(0);
        }
        return "";
    }
}
