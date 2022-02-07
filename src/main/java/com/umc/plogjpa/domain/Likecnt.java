package com.umc.plogjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Likecnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LikecntIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx", referencedColumnName = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postIdx", referencedColumnName = "postIdx")
    private Post post;

    private String status;

    @Builder
    public Likecnt(long LikecntIdx,User user,Post post, String status){
        this.LikecntIdx=LikecntIdx;
        this.user = user;
        this.post = post;
        this.status = status;
    }

}
