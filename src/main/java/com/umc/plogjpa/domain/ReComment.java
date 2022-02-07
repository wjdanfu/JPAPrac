package com.umc.plogjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class ReComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recommentIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx", referencedColumnName = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentIdx")
    private Comment comment;

    private String content;

    @Builder
    public ReComment(String content,User user,Comment comment){
        this.content=content;
        this.user = user;
        this.comment = comment;
    }
}
