package com.umc.plogjpa.user;

import com.umc.plogjpa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {

    private String name;
    private String password;

    @Builder
    public LoginDto(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .password(password)
                .build();
    }
}
