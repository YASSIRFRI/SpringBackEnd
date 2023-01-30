package com.yassir.demo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ContentSerializer {

    @Autowired
    public final ObjectMapper mapper = new ObjectMapper();

    public <Content> Content fromJson(String json, Class<Content> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
