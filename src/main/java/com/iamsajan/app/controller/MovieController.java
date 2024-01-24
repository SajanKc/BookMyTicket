package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.MovieRequestDto;
import com.iamsajan.app.dto.response.MovieResponseDto;
import com.iamsajan.app.service.MovieService;
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
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final Logger log = LoggerFactory.getLogger(MovieController.class);
    private final MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<MovieResponseDto> createMovie(MovieRequestDto movieRequestDto) {
        log.info("Request to create movie {}", movieRequestDto);
        MovieResponseDto movieResponseDto = movieService.createMovie(movieRequestDto);
        return ResponseEntity.ok().body(movieResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(Pageable pageable) {
        log.info("Request to get a page of Movies");
        Page<MovieResponseDto> movieList = movieService.getAllMovies(pageable);
        return ResponseEntity.ok().body(movieList.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<MovieResponseDto> updateMovie(MovieRequestDto movieRequestDto) {
        log.info("Request to update movie {}", movieRequestDto);
        MovieResponseDto movieResponseDto = movieService.updateMovie(movieRequestDto);
        return ResponseEntity.ok().body(movieResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        log.info("Request to delete movie {}", id);
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
