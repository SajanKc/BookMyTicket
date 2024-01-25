package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.CinemaSeatRequestDto;
import com.iamsajan.app.dto.response.CinemaSeatResponseDto;
import com.iamsajan.app.service.CinemaSeatService;
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
@RequestMapping("/api/v1/cinema-seat")
public class CinemaSeatController {

    private final Logger log = LoggerFactory.getLogger(CinemaSeatController.class);
    private final CinemaSeatService cinemaSeatService;

    @PostMapping("/create")
    public ResponseEntity<CinemaSeatResponseDto> createCinemaSeat(CinemaSeatRequestDto cinemaSeatRequestDto) {
        log.info("Request to create cinema hall {}", cinemaSeatRequestDto);
        return ResponseEntity.ok(cinemaSeatService.createCinemaSeat(cinemaSeatRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<CinemaSeatRequestDto>> getAllCinemaSeat(Pageable pageable) {
        log.info("Request to get a page of CinemaSeats");
        Page<CinemaSeatRequestDto> cinemaSeatRequestDtoPage = cinemaSeatService.getAllCinemaSeat(pageable);
        return ResponseEntity.ok(cinemaSeatRequestDtoPage.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<CinemaSeatResponseDto> updateCinemaSeat(CinemaSeatRequestDto cinemaSeatRequestDto) {
        log.info("Request to update cinema seat {}", cinemaSeatRequestDto);
        return ResponseEntity.ok(cinemaSeatService.updateCinemaSeat(cinemaSeatRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCinemaSeat(@PathVariable String id) {
        log.info("Request to delete cinema seat {}", id);
        cinemaSeatService.deleteCinemaSeat(id);
        return ResponseEntity.noContent().build();
    }
}
