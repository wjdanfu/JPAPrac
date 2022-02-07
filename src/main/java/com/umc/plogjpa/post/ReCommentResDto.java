package com.umc.plogjpa.post;

import com.umc.plogjpa.domain.ReComment;
import com.umc.plogjpa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReCommentResDto {
    private long userIdx;
    private String userName;
    private String content;

    @Builder
    public ReCommentResDto(String content, User user) {
        this.userName = user.getName();
        this.userIdx = user.getUserIdx();
        this.content = content;
    }
}
