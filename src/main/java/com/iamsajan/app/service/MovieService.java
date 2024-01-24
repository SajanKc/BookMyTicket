package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.MovieRequestDto;
import com.iamsajan.app.dto.response.MovieResponseDto;
import com.iamsajan.app.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    MovieResponseDto createMovie(MovieRequestDto movieRequestDto);

    Page<MovieResponseDto> getAllMovies(Pageable pageable);

    MovieResponseDto updateMovie(MovieRequestDto movieRequestDto);

    void deleteMovie(String id);

    Movie findMovieById(String movieId);
}
