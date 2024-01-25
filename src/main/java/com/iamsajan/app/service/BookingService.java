package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.BookingRequestDto;
import com.iamsajan.app.dto.response.BookingResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
    BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);

    Page<BookingResponseDto> getBooking(Pageable pageable);

    BookingResponseDto updateBooking(BookingRequestDto bookingRequestDto);

    void deleteBooking(String id);
}
