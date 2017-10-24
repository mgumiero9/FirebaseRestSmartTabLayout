package com.mgumiero9.firebasecommunication.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Customer Class
 */

public class Customer {

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
