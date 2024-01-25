package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.BookingRequestDto;
import com.iamsajan.app.dto.response.BookingResponseDto;
import com.iamsajan.app.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/booking")
public class BookingController {
    private final Logger log = LoggerFactory.getLogger(BookingController.class);
    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingResponseDto> createBooking(BookingRequestDto bookingRequestDto) {
        log.info("createBooking: {}", bookingRequestDto);
        BookingResponseDto bookingResponseDto = bookingService.createBooking(bookingRequestDto);
        return ResponseEntity.ok(bookingResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDto>> getBooking(Pageable pageable) {
        log.info("Request to get Booking: {}", pageable);
        Page<BookingResponseDto> bookingResponseDto = bookingService.getBooking(pageable);
        return ResponseEntity.ok(bookingResponseDto.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<BookingResponseDto> updateBooking(BookingRequestDto bookingRequestDto) {
        log.info("updateBooking: {}", bookingRequestDto);
        BookingResponseDto bookingResponseDto = bookingService.updateBooking(bookingRequestDto);
        return ResponseEntity.ok(bookingResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") String id) {
        log.info("deleteBooking: {}", id);
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
