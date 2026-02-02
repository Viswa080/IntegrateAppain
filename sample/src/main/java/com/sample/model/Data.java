package com.sample.model;

@lombok.Data
public class Data {
    private String name;
    private String type;
    private String phno;

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", phno='" + phno + '\'' +
                '}';
    }
}
