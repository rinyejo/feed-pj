package com.ryj.feedproject.controller;


import com.ryj.feedproject.dto.FeedRequestDto;
import com.ryj.feedproject.dto.FeedResponseDto;
import com.ryj.feedproject.repository.FeedRepository;
import com.ryj.feedproject.service.FeedService;
import com.ryj.feedproject.entity.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {

    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @PostMapping
    public FeedResponseDto createFeed(@RequestBody FeedRequestDto requestDto){
        System.out.println("안녕");
        return feedService.createFeed(requestDto);
    }

    @GetMapping
    public List<FeedResponseDto> getAllFeeds() {
        return feedService.getAllFeeds();
    }

//    @GetMapping("/{id}")
//    public FeedResponseDto getFeed(@PathVariable Long id){
//        return feedService.getFeed(id);
//
//    }

    @PutMapping("/{id}")
    public Long updateFeed(@PathVariable Long id, @RequestBody FeedRequestDto requestDto){
        return feedService.updateFeed(id, requestDto);

    }

    @DeleteMapping("/{id}")
    public Long deleteFeed(@PathVariable Long id){
        return feedService.deleteFeed(id);
    }

}
