package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.ShowRequestDto;
import com.iamsajan.app.dto.response.ShowResponseDto;
import com.iamsajan.app.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/show")
public class ShowController {

    private final Logger log = LoggerFactory.getLogger(ShowController.class);
    private final ShowService showService;

    @PostMapping("/create")
    public ResponseEntity<ShowResponseDto> createShow(ShowRequestDto showRequestDto) {
        log.info("Request to create show {}", showRequestDto);
        ShowResponseDto showResponseDto = showService.createShow(showRequestDto);
        return ResponseEntity.ok().body(showResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<ShowResponseDto>> getAllShows(Pageable pageable){
        log.info("Request to get a page of Shows");
        Page<ShowResponseDto> showList = showService.getAllShows(pageable);
        return ResponseEntity.ok().body(showList.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<ShowResponseDto> updateShow(ShowRequestDto showRequestDto){
        log.info("Request to update show {}", showRequestDto);
        ShowResponseDto showResponseDto = showService.updateShow(showRequestDto);
        return ResponseEntity.ok().body(showResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable String id){
        log.info("Request to delete show {}", id);
        showService.deleteShow(id);
        return ResponseEntity.ok().build();
    }

}
