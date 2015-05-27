package com.appdirect.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlElement(name = "firstName")
    private String firstName;
    @XmlElement(name = "openId")
    private String openId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (openId != null ? !openId.equals(user.openId) : user.openId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }
}
