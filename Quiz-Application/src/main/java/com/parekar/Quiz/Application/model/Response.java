package com.parekar.Quiz.Application.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {

    private Integer id;
    private String response;

    public Response(){};

    public Response(Integer id, String response) {
        this.id = id;
        this.response = response;
    }

    public Integer getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
