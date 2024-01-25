package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.ShowSeatRequestDto;
import com.iamsajan.app.dto.response.ShowSeatResponseDto;
import com.iamsajan.app.service.ShowSeatService;
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
@RequestMapping("/api/v1/show-seat")
public class ShowSeatController {

    private final Logger log = LoggerFactory.getLogger(ShowSeatController.class);
    private final ShowSeatService showSeatService;

    @PostMapping("/create")
    public ResponseEntity<ShowSeatResponseDto> createShowSeat(ShowSeatRequestDto showSeatRequestDto) {
        log.info("Request to create show seat: {}", showSeatRequestDto);
        ShowSeatResponseDto showSeatResponseDto = showSeatService.createShowSeat(showSeatRequestDto);
        return ResponseEntity.ok(showSeatResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<ShowSeatResponseDto>> getShowSeats(Pageable pageable) {
        log.info("Request to get show seat: {}", pageable);
        Page<ShowSeatResponseDto> showSeatResponseDto = showSeatService.getShowSeats(pageable);
        return ResponseEntity.ok(showSeatResponseDto.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<ShowSeatResponseDto> updateShowSeat(ShowSeatRequestDto showSeatRequestDto) {
        log.info("Request to update show seat: {}", showSeatRequestDto);
        ShowSeatResponseDto showSeatResponseDto = showSeatService.updateShowSeat(showSeatRequestDto);
        return ResponseEntity.ok(showSeatResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShowSeat(@PathVariable String id) {
        log.info("Request to delete show seat: {}", id);
        showSeatService.deleteShowSeat(id);
        return ResponseEntity.ok().build();
    }
}
