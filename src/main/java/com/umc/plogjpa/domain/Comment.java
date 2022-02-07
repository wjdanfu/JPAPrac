package com.umc.plogjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "comment")
@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx", referencedColumnName = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postIdx", referencedColumnName = "postIdx")
    private Post post;

    private String content;

    @Builder
    public Comment(String content,User user,Post post){
        this.content=content;
        this.user = user;
        this.post = post;
    }


}
