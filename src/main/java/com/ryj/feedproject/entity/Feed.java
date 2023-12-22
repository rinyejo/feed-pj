package com.ryj.feedproject.entity;


import com.ryj.feedproject.dto.FeedRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="feed")
@NoArgsConstructor
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    public Feed(FeedRequestDto requestDto){
        this.username = getUsername();
        this.password = getPassword();
        this.contents = getPassword();
    }

    public void update(FeedRequestDto requestDto){
        this.username = getUsername();
        this.password = getPassword();
        this.contents = getPassword();
    }


}
