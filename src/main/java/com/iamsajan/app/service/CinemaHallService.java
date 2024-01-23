package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.CinemaHallRequestDto;
import com.iamsajan.app.dto.response.CinemaHallResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CinemaHallService {

    CinemaHallResponseDto createCinemaHall(CinemaHallRequestDto cinemaHallRequestDto);

    Page<CinemaHallResponseDto> getAllCinemaHalls(Pageable pageable);

    CinemaHallResponseDto updateCinemaHall(CinemaHallRequestDto cinemaHallRequestDto);

    void deleteCinemaHall(String id);
}
