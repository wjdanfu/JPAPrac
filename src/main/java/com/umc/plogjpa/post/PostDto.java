package com.umc.plogjpa.post;

import com.umc.plogjpa.domain.Post;
import com.umc.plogjpa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String imgUrl;
    private User user;

    @Builder
    public PostDto(String title, String content,String imgUrl,User user){
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.user = user;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .imgUrl(imgUrl)
                .user(user)
                .build();
    }
}
