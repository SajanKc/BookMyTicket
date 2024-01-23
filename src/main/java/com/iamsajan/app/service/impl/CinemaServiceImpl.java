package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.request.CinemaRequestDto;
import com.iamsajan.app.dto.response.CinemaResponseDto;
import com.iamsajan.app.model.Cinema;
import com.iamsajan.app.model.City;
import com.iamsajan.app.repository.CinemaRepository;
import com.iamsajan.app.service.CinemaService;
import com.iamsajan.app.service.CityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final Logger log = LoggerFactory.getLogger(CinemaServiceImpl.class);

    private final CityService cityService;

    private final CinemaRepository cinemaRepository;

    @Override
    public CinemaResponseDto createCinema(CinemaRequestDto cinemaRequestDto) {
        log.info("Request to create cinema {}", cinemaRequestDto);
        if (cinemaRequestDto == null) {
            log.warn("Cinema request cannot be null !!!");
            throw new RuntimeException("Cinema request cannot be null !!!");
        }

        if (cinemaRequestDto.getCityId() == null) {
            log.error("City id cannot be null !!!");
            throw new RuntimeException("City id cannot be null !!!");
        }
        City city = cityService.findById(cinemaRequestDto.getCityId());

        Cinema cinema = new Cinema();
        cinema.setId(UUID.randomUUID().toString());
        cinema.setName(cinemaRequestDto.getName());
        cinema.setTotalCinemaHalls(cinemaRequestDto.getTotalCinemaHalls());
        cinema.setCity(city);

        Cinema savedCinema = cinemaRepository.save(cinema);
        log.info("Cinema created {}", savedCinema);

        return cinemaResponseMapper(savedCinema);
    }

    @Override
    public Page<Cinema> getAllCinema(Pageable pageable) {
        log.info("Request to get all cinemas");
        return cinemaRepository.findAll(pageable);
    }

    @Override
    public CinemaResponseDto updateCinema(CinemaRequestDto cinemaRequestDto) {
        log.info("Request to update cinema {}", cinemaRequestDto);
        if (cinemaRequestDto.getId() == null) {
            log.warn("Cinema id cannot be null !!!");
            throw new RuntimeException("Cinema id cannot be null !!!");
        }

        if (cinemaRequestDto.getCityId() == null) {
            log.warn("City id cannot be null !!!");
            throw new RuntimeException("City id cannot be null !!!");
        }
        City city = cityService.findById(cinemaRequestDto.getCityId());

        Cinema cinema = cinemaRepository.findById(cinemaRequestDto.getId()).orElseThrow(() -> new RuntimeException("Cinema not found !!!"));
        // update old cinema data with new cinema data
        cinema.setName(cinemaRequestDto.getName());
        cinema.setTotalCinemaHalls(cinemaRequestDto.getTotalCinemaHalls());
        cinema.setCity(city);

        Cinema savedCinema = cinemaRepository.save(cinema);
        log.info("Cinema updated {}", savedCinema);

        return cinemaResponseMapper(savedCinema);
    }

    @Override
    public void deleteCinema(String id) {
        log.info("Request to delete cinema {}", id);
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cinema not found !!!"));
        cinemaRepository.delete(cinema);
    }

    @Override
    public Cinema findById(String cinemaId) {
        return cinemaRepository.findById(cinemaId).orElseThrow(() -> new RuntimeException("Cinema not found !!!"));
    }

    public CinemaResponseDto cinemaResponseMapper(Cinema cinema) {
        return CinemaResponseDto.builder()
                .id(cinema.getId())
                .name(cinema.getName())
                .totalCinemaHalls(cinema.getTotalCinemaHalls())
                .cityId(cinema.getCity())
                .build();
    }
}
