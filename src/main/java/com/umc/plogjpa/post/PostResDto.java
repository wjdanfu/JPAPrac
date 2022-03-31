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
public class PostResDto {
    private String imgUrl;
    private String title;
    private String content;

    @Builder
    public PostResDto(Post entity){
        this.imgUrl = entity.getImgUrl();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

}
