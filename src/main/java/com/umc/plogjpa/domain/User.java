package com.umc.plogjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userIdx;

    @Column(nullable = false)
    private String name;


    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private String password;
    private String comment;
    @Column(length = 300)
    private String userImage;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    private List<Likecnt> likecnts = new ArrayList<>();

    @Builder
    public User(String name,String password,String comment,
                String userImage){
        this.name=name;
        this.password=password;
        this.comment=comment;
        this.userImage=userImage;
    }
}
