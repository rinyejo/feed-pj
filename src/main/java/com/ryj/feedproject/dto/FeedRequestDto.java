package com.ryj.feedproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FeedRequestDto {

    private String username;
    private String password;
    private String contents;
}
//
