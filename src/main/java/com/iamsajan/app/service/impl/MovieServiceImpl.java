package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.request.MovieRequestDto;
import com.iamsajan.app.dto.response.MovieResponseDto;
import com.iamsajan.app.model.Movie;
import com.iamsajan.app.repository.MovieRepository;
import com.iamsajan.app.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MovieRepository movieRepository;

    @Override
    public MovieResponseDto createMovie(MovieRequestDto movieRequestDto) {
        log.info("Request to create movie {}", movieRequestDto);
        if (movieRequestDto == null) {
            log.warn("Movie request cannot be null !!!");
            throw new RuntimeException("Movie request cannot be null !!!");
        }

        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        movie.setDuration(movieRequestDto.getDuration());
        movie.setLanguage(movieRequestDto.getLanguage());
        movie.setReleaseDate(movieRequestDto.getReleaseDate());
        movie.setCountry(movieRequestDto.getCountry());
        movie.setGenre(movieRequestDto.getGenre());

        Movie savedMovie = movieRepository.save(movie);
        return movieResponseMapper(savedMovie);
    }

    @Override
    public Page<MovieResponseDto> getAllMovies(Pageable pageable) {

        return movieRepository.findAll(pageable).map(
                movie -> MovieResponseDto.builder()
                        .id(movie.getId())
                        .title(movie.getTitle())
                        .description(movie.getDescription())
                        .duration(movie.getDuration())
                        .language(movie.getLanguage())
                        .releaseDate(movie.getReleaseDate().toString())
                        .country(movie.getCountry())
                        .genre(movie.getGenre())
                        .build()
        );
    }

    @Override
    public MovieResponseDto updateMovie(MovieRequestDto movieRequestDto) {
        log.info("Request to update movie {}", movieRequestDto);
        if (movieRequestDto == null) {
            log.warn("Movie request cannot be null !!!");
            throw new RuntimeException("Movie request cannot be null !!!");
        }
        if (movieRequestDto.getId() == null) {
            log.warn("Movie id cannot be null !!!");
            throw new RuntimeException("Movie id cannot be null !!!");
        }

        Movie movie = movieRepository.findById(movieRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("Movie not found !!!"));

        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        movie.setDuration(movieRequestDto.getDuration());
        movie.setLanguage(movieRequestDto.getLanguage());
        movie.setReleaseDate(movieRequestDto.getReleaseDate());
        movie.setCountry(movieRequestDto.getCountry());
        movie.setGenre(movieRequestDto.getGenre());

        Movie savedMovie = movieRepository.save(movie);

        return movieResponseMapper(savedMovie);
    }

    @Override
    public void deleteMovie(String id) {
        log.info("Request to delete movie {}", id);
        if (id == null) throw new RuntimeException("Movie id cannot be null !!!");
        movieRepository.deleteById(id);
    }

    @Override
    public Movie findMovieById(String movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found !!!"));
    }

    private MovieResponseDto movieResponseMapper(Movie savedMovie) {
        return MovieResponseDto.builder()
                .id(savedMovie.getId())
                .title(savedMovie.getTitle())
                .description(savedMovie.getDescription())
                .duration(savedMovie.getDuration())
                .language(savedMovie.getLanguage())
                .releaseDate(savedMovie.getReleaseDate().toString())
                .country(savedMovie.getCountry())
                .genre(savedMovie.getGenre())
                .build();
    }
}
