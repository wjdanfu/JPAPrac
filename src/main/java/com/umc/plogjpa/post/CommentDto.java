package com.umc.plogjpa.post;

import com.umc.plogjpa.domain.Comment;
import com.umc.plogjpa.domain.Post;
import com.umc.plogjpa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {
    private String content;
    private User user;
    private Post post;

    @Builder
    public CommentDto(String content,Post post,User user){
        this.content = content;
        this.post = post;
        this.user = user;
    }


    public Comment toEntity(){
        return Comment.builder()
                .content(content)
                .user(user)
                .post(post)
                .build();
    }
}
