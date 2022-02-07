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
public class CommentResDto {
    private long commentIdx;
    private long userIdx;
    private String userName;
    private String content;
    private List<ReCommentResDto> reComment;

    @Builder
    public CommentResDto(long commentIdx,String content, User user) {
        this.commentIdx = commentIdx;
        this.userName = user.getName();
        this.userIdx = user.getUserIdx();
        this.content = content;
    }
}
