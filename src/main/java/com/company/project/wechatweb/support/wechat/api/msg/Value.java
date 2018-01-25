package com.company.project.wechatweb.support.wechat.api.msg;

public class Value {

    private String value;

    private String color;

    public Value(String value) {
        this(value, null);

    }

    public Value(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
