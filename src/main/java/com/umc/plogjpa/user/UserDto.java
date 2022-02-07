package com.umc.plogjpa.user;


import com.umc.plogjpa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class UserDto {
    private String name;
    private String password;
    private String comment;
    private String user_image;

    @Builder
    public UserDto(String name, String password,String comment,String user_image){
        this.name = name;
        this.password = password;
        this.comment = comment;
        this.user_image = user_image;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .comment(comment)
                .password(password)
                .userImage(user_image)
                .build();
    }

}
