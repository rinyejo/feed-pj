package com.ryj.feedproject.dto;

import com.ryj.feedproject.entity.Feed;
import lombok.Getter;

@Getter
public class FeedResponseDto {

    private Long id;
    private String username;
    private String password;
    private String contents;

    public FeedResponseDto(Feed feed) {
        this.id = feed.getId();
        this.username = feed.getUsername();
        this.password = feed.getPassword();
        this.contents = feed.getContents();
    }
}
//