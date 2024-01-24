package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.request.CinemaHallRequestDto;
import com.iamsajan.app.dto.response.CinemaHallResponseDto;
import com.iamsajan.app.model.Cinema;
import com.iamsajan.app.model.CinemaHall;
import com.iamsajan.app.repository.CinemaHallRepository;
import com.iamsajan.app.service.CinemaHallService;
import com.iamsajan.app.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CinemaHallServiceImpl implements CinemaHallService {

    private final Logger log = LoggerFactory.getLogger(CinemaHallServiceImpl.class);
    private final CinemaService cinemaService;
    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public Page<CinemaHallResponseDto> getAllCinemaHalls(Pageable pageable) {
        return cinemaHallRepository.findAll(pageable)
                .map(cinemaHall -> CinemaHallResponseDto.builder()
                        .id(cinemaHall.getId())
                        .name(cinemaHall.getName())
                        .totalSeats(cinemaHall.getTotalSeats())
                        .cinemaId(cinemaHall.getCinema().getId())
                        .build()
                );
    }

    @Override
    public CinemaHallResponseDto updateCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        log.info("Request to update cinema hall {}", cinemaHallRequestDto);
        if (cinemaHallRequestDto == null) {
            log.warn("Cinema hall request cannot be null !!!");
            throw new RuntimeException("Cinema hall request cannot be null !!!");
        }

        if (cinemaHallRequestDto.getCinemaId() == null) {
            log.error("Cinema id cannot be null !!!");
            throw new RuntimeException("Cinema id cannot be null !!!");
        }

        Cinema cinema = cinemaService.findById(cinemaHallRequestDto.getCinemaId());

        CinemaHall cinemaHall = cinemaHallRepository.findById(cinemaHallRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("Cinema hall not found !!!"));
        // update cinema hall
        cinemaHall.setName(cinemaHallRequestDto.getName());
        cinemaHall.setTotalSeats(cinemaHallRequestDto.getTotalSeats());
        cinemaHall.setCinema(cinema);

        CinemaHall savedCinemaHall = cinemaHallRepository.save(cinemaHall);
        log.info("Cinema hall updated {}", savedCinemaHall);

        return cinemaHallMapper(savedCinemaHall);
    }

    @Override
    public void deleteCinemaHall(String id) {
        log.info("Request to delete cinema hall {}", id);
        if (id == null) throw new RuntimeException("Cinema hall id cannot be null !!!");
        cinemaHallRepository.deleteById(id);
    }

    @Override
    public CinemaHall findCinemaHallById(String cinemaHallId) {
        return cinemaHallRepository.findById(cinemaHallId)
                .orElseThrow(() -> new RuntimeException("Cinema hall not found !!!"));
    }

    @Override
    public CinemaHallResponseDto createCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        log.info("Request to create cinema hall {}", cinemaHallRequestDto);
        if (cinemaHallRequestDto == null) {
            log.warn("Cinema hall request cannot be null !!!");
            throw new RuntimeException("Cinema hall request cannot be null !!!");
        }

        if (cinemaHallRequestDto.getCinemaId() == null) {
            log.error("Cinema id cannot be null !!!");
            throw new RuntimeException("Cinema id cannot be null !!!");
        }

        Cinema cinema = cinemaService.findById(cinemaHallRequestDto.getCinemaId());

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(UUID.randomUUID().toString());
        cinemaHall.setName(cinemaHallRequestDto.getName());
        cinemaHall.setTotalSeats(cinemaHallRequestDto.getTotalSeats());
        cinemaHall.setCinema(cinema);

        CinemaHall savedCinemaHall = cinemaHallRepository.save(cinemaHall);
        log.info("Cinema hall created {}", savedCinemaHall);

        return cinemaHallMapper(savedCinemaHall);
    }

    private CinemaHallResponseDto cinemaHallMapper(CinemaHall cinemaHall) {
        return CinemaHallResponseDto.builder()
                .id(cinemaHall.getId())
                .name(cinemaHall.getName())
                .totalSeats(cinemaHall.getTotalSeats())
                .cinemaId(cinemaHall.getCinema().getId())
                .build();
    }
}
