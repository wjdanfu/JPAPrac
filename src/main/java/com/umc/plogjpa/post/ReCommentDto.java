package com.umc.plogjpa.post;

import com.umc.plogjpa.domain.Comment;
import com.umc.plogjpa.domain.Post;
import com.umc.plogjpa.domain.ReComment;
import com.umc.plogjpa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReCommentDto {
    private String content;
    private User user;
    private Comment comment;


    public ReComment toEntity(){
        return ReComment.builder()
                .content(content)
                .user(user)
                .comment(comment)
                .build();
    }
}
