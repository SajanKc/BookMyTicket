package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.ShowSeatRequestDto;
import com.iamsajan.app.dto.response.ShowSeatResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShowSeatService {
    ShowSeatResponseDto createShowSeat(ShowSeatRequestDto showSeatRequestDto);

    Page<ShowSeatResponseDto> getShowSeats(Pageable pageable);

    ShowSeatResponseDto updateShowSeat(ShowSeatRequestDto showSeatRequestDto);

    void deleteShowSeat(String id);
}
