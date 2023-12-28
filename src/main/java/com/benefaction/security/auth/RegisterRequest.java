package com.benefaction.security.auth;


import com.benefaction.security.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private String email;
    private String password;
}
