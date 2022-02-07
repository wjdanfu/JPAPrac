package com.umc.plogjpa.post;


import com.umc.plogjpa.domain.Comment;
import com.umc.plogjpa.domain.Post;
import com.umc.plogjpa.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostIdxResDto {
    private Long postIdx;
    private String imgUrl;
    private String title;
    private String content;
    private long userIdx;
    private String userName;
    private String userImage;
    private List<CommentResDto> comments;


    @Builder
    public PostIdxResDto(Post entity){
        this.postIdx = entity.getPostIdx();
        this.imgUrl = entity.getImgUrl();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.userIdx = entity.getUser().getUserIdx();
        this.userName = entity.getUser().getName();
        this.userImage = entity.getUser().getUserImage();
    }
}
