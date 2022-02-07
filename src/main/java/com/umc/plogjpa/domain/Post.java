package com.umc.plogjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx", referencedColumnName = "userIdx")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Likecnt> likecnts = new ArrayList<>();

    private String title;
    private String content;
    private String imgUrl;

    @Builder
    public Post(long postIdx,String title,String content,String imgUrl,User user){
        this.postIdx=postIdx;
        this.title=title;
        this.content=content;
        this.imgUrl=imgUrl;
        this.user = user;
    }
}
