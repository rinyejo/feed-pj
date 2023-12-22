package com.ryj.feedproject.service;


import com.ryj.feedproject.dto.FeedRequestDto;
import com.ryj.feedproject.dto.FeedResponseDto;
import com.ryj.feedproject.entity.Feed;
import com.ryj.feedproject.repository.FeedRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository){
        this.feedRepository = feedRepository;
    }

    public FeedResponseDto createFeed(FeedRequestDto requestDto){

        Feed feed = new Feed(requestDto);

        Feed saveFeed = feedRepository.save(feed);

        FeedResponseDto feedResponseDto = new FeedResponseDto(saveFeed);

        return feedResponseDto;
    }
    public List<FeedResponseDto> getAllFeeds(){ //getfeeds id값과 동일한 피드만 or 모든 피드를 출력

        return feedRepository.findAll().stream().map(FeedResponseDto::new).toList();
    }



    @Transactional
    public Long updateFeed(Long id, FeedRequestDto requestDto){
        Feed feed = findFeed(id);
        feed.update(requestDto);
        return id;

    }

    public Long deleteFeed(Long id){
        Feed feed = findFeed(id);
        feedRepository.delete(feed);
        return id;
    }


    private Feed findFeed(Long id) {
        return feedRepository.findById(id).orElseThrow( () ->
                new IllegalArgumentException("해당 피드를 찾을 수 없습니다!"));
    }
}//
