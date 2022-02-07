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
    private Long ListcntIdx;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userIdx", referencedColumnName = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "postIdx", referencedColumnName = "postIdx")
    private Post post;

    @Column(columnDefinition = "ACTIVE")
    private String status;

    @Builder
    public Likecnt(long ListcntIdx,User user,Post post, String status){
        this.ListcntIdx=ListcntIdx;
        this.user = user;
        this.post = post;
        this.status = status;
    }

    public void update(String status) {

        this.status = status;
    }
}
