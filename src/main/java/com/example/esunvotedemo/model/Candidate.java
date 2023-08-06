package com.example.esunvotedemo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Candidate {
    @NotBlank
    String id;
    @NotBlank
    String name;

    @NotNull
    Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
