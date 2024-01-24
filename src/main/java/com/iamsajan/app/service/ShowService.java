package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.ShowRequestDto;
import com.iamsajan.app.dto.response.ShowResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShowService {
    ShowResponseDto createShow(ShowRequestDto showRequestDto);

    Page<ShowResponseDto> getAllShows(Pageable pageable);

    ShowResponseDto updateShow(ShowRequestDto showRequestDto);

    void deleteShow(String id);
}
