package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.request.ShowRequestDto;
import com.iamsajan.app.dto.response.ShowResponseDto;
import com.iamsajan.app.model.CinemaHall;
import com.iamsajan.app.model.Movie;
import com.iamsajan.app.model.Show;
import com.iamsajan.app.repository.ShowRepository;
import com.iamsajan.app.service.CinemaHallService;
import com.iamsajan.app.service.MovieService;
import com.iamsajan.app.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {
    private final Logger log = LoggerFactory.getLogger(ShowServiceImpl.class);
    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Override
    public ShowResponseDto createShow(ShowRequestDto showRequestDto) {
        log.info("Request to create show {}", showRequestDto);
        if (showRequestDto == null) {
            log.warn("Show request cannot be null !!!");
            throw new RuntimeException("Show request cannot be null !!!");
        }
        // check if movie exists
        Movie movie = movieService.findMovieById(showRequestDto.getMovieId());

        // check if cinema hall exists
        CinemaHall cinemaHall = cinemaHallService.findCinemaHallById(showRequestDto.getCinemaHallId());

        Show show = new Show();
        show.setId(UUID.randomUUID().toString());
        return saveAndGetShowResponseDto(showRequestDto, movie, cinemaHall, show);
    }

    @Override
    public Page<ShowResponseDto> getAllShows(Pageable pageable) {
        return showRepository.findAll(pageable).map(
                show -> ShowResponseDto.builder()
                        .id(show.getId())
                        .dateTime(show.getDateTime())
                        .startTime(show.getStartTime())
                        .endTime(show.getEndTime())
                        .movieId(show.getMovie().getId())
                        .cinemaHallId(show.getCinemaHall().getId())
                        .build()
        );
    }

    @Override
    public ShowResponseDto updateShow(ShowRequestDto showRequestDto) {
        log.info("Request to update show {}", showRequestDto);

        Movie movie;
        CinemaHall cinemaHall;

        if (showRequestDto == null) {
            log.warn("Show request cannot be null !!!");
            throw new RuntimeException("Show request cannot be null !!!");
        }

        if (showRequestDto.getId() == null) {
            log.error("Show id cannot be null !!!");
            throw new RuntimeException("Show id cannot be null !!!");
        }

        if (showRequestDto.getMovieId() == null) {
            log.error("Movie id cannot be null !!!");
            throw new RuntimeException("Movie id cannot be null !!!");
        } else {
            movie = movieService.findMovieById(showRequestDto.getMovieId());
        }

        if (showRequestDto.getCinemaHallId() == null) {
            log.error("Cinema hall id cannot be null !!!");
            throw new RuntimeException("Cinema hall id cannot be null !!!");
        } else {
            cinemaHall = cinemaHallService.findCinemaHallById(showRequestDto.getCinemaHallId());
        }

        // check if show exists
        Show show = showRepository.findById(showRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("Show not found !!!"));

        return saveAndGetShowResponseDto(showRequestDto, movie, cinemaHall, show);
    }

    @Override
    public void deleteShow(String id) {
        log.info("Request to delete show {}", id);
        if (id == null) {
            log.warn("Show id cannot be null !!!");
            throw new RuntimeException("Show id cannot be null !!!");
        }
        showRepository.deleteById(id);
    }

    @Override
    public Show findShowById(String showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found !!!"));
    }

    private ShowResponseDto saveAndGetShowResponseDto(ShowRequestDto showRequestDto, Movie movie, CinemaHall cinemaHall, Show show) {
        show.setDateTime(showRequestDto.getDateTime());
        show.setStartTime(showRequestDto.getStartTime());
        show.setEndTime(showRequestDto.getEndTime());
        show.setMovie(movie);
        show.setCinemaHall(cinemaHall);

        showRepository.save(show);
        return showResponseMapper(show);
    }

    public ShowResponseDto showResponseMapper(Show show) {
        return ShowResponseDto.builder()
                .id(show.getId())
                .dateTime(show.getDateTime())
                .startTime(show.getStartTime())
                .endTime(show.getEndTime())
                .movieId(show.getMovie() != null ? show.getMovie().getId() : null)
                .cinemaHallId(show.getCinemaHall() != null ? show.getCinemaHall().getId() : null)
                .build();
    }
}
