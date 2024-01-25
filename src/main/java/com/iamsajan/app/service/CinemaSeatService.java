package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.CinemaSeatRequestDto;
import com.iamsajan.app.dto.response.CinemaSeatResponseDto;
import com.iamsajan.app.model.CinemaSeat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CinemaSeatService {
    CinemaSeatResponseDto createCinemaSeat(CinemaSeatRequestDto cinemaSeatRequestDto);

    Page<CinemaSeatRequestDto> getAllCinemaSeat(Pageable pageable);

    CinemaSeatResponseDto updateCinemaSeat(CinemaSeatRequestDto cinemaSeatRequestDto);

    void deleteCinemaSeat(String id);

    CinemaSeat findCinemaById(String cinemaSeatId);
}
