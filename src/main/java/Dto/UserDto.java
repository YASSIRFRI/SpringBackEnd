package Dto;

import com.yassir.demo.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private String fname;
    private String lname;
    private String email;
    private String password;

    public static UserDto toDTO(User user) {
        return UserDto.builder()
                .fname(user.getFname())
                .lname(user.getLname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    
}
