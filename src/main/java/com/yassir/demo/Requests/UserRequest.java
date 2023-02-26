package com.yassir.demo.Requests;
import java.io.Serializable;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;






@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable{
    private String fname;
    private String lname;
    private String email;
    private String password;

    
}
