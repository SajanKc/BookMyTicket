package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.CinemaRequestDto;
import com.iamsajan.app.dto.response.CinemaResponseDto;
import com.iamsajan.app.model.Cinema;
import com.iamsajan.app.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final Logger log = LoggerFactory.getLogger(CinemaController.class);

    private final CinemaService cinemaService;

    @PostMapping("/create")
    public ResponseEntity<CinemaResponseDto> createCity(@RequestBody CinemaRequestDto cinemaRequestDto) {
        log.info("Request to create cinema {}", cinemaRequestDto);
        CinemaResponseDto cinemaResponseDto = cinemaService.createCinema(cinemaRequestDto);
        return ResponseEntity.ok().body(cinemaResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas(Pageable pageable) {
        log.info("Request to get all cinemas {}", pageable);
        Page<Cinema> cinemaList = cinemaService.getAllCinema(pageable);
        return ResponseEntity.ok().body(cinemaList.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<CinemaResponseDto> updateCinema(@RequestBody CinemaRequestDto cinemaRequestDto) {
        log.info("Request to update cinema {}", cinemaRequestDto);
        CinemaResponseDto cinemaResponseDto = cinemaService.updateCinema(cinemaRequestDto);
        return ResponseEntity.ok().body(cinemaResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCinema(@PathVariable String id) {
        log.info("Request to delete cinema {}", id);
        cinemaService.deleteCinema(id);
        return ResponseEntity.ok().build();
    }
}