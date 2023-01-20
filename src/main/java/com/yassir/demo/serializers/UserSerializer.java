package com.yassir.demo.serializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserSerializer {
    @Autowired
    public final ObjectMapper mapper = new ObjectMapper();

    public <User> User fromJson(String json, Class<User> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }







    
}
