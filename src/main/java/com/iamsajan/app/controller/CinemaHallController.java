package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.CinemaHallRequestDto;
import com.iamsajan.app.dto.response.CinemaHallResponseDto;
import com.iamsajan.app.service.CinemaHallService;
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
@RequestMapping("/api/v1/cinema-hall")
public class CinemaHallController {

    private final Logger log = LoggerFactory.getLogger(CinemaHallController.class);
    private final CinemaHallService cinemaHallService;

    @PostMapping("/create")
    public ResponseEntity<CinemaHallResponseDto> createCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        log.info("Request to create cinema hall {}", cinemaHallRequestDto);
        CinemaHallResponseDto cinemaHallResponseDto = cinemaHallService.createCinemaHall(cinemaHallRequestDto);
        return ResponseEntity.ok().body(cinemaHallResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<CinemaHallResponseDto>> getAllCinemaHalls(Pageable pageable) {
        log.info("Request to get a page of CinemaHalls");
        Page<CinemaHallResponseDto> cinemaHallList = cinemaHallService.getAllCinemaHalls(pageable);
        return ResponseEntity.ok().body(cinemaHallList.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<CinemaHallResponseDto> updateCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        log.info("Request to update cinema hall {}", cinemaHallRequestDto);
        CinemaHallResponseDto cinemaHallResponseDto = cinemaHallService.updateCinemaHall(cinemaHallRequestDto);
        return ResponseEntity.ok().body(cinemaHallResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCinemaHall(@PathVariable String id) {
        log.info("Request to delete cinema hall {}", id);
        cinemaHallService.deleteCinemaHall(id);
        return ResponseEntity.noContent().build();
    }
}
