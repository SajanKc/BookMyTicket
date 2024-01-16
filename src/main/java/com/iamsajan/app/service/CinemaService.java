package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.CinemaRequestDto;
import com.iamsajan.app.dto.response.CinemaResponseDto;
import com.iamsajan.app.model.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CinemaService {
    CinemaResponseDto createCinema(CinemaRequestDto cinemaRequestDto);

    Page<Cinema> getAllCinema(Pageable pageable);

    CinemaResponseDto updateCinema(CinemaRequestDto cinemaRequestDto);

    void deleteCinema(String id);
}
