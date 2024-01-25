package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.request.ShowSeatRequestDto;
import com.iamsajan.app.dto.response.ShowSeatResponseDto;
import com.iamsajan.app.model.Booking;
import com.iamsajan.app.model.CinemaSeat;
import com.iamsajan.app.model.Show;
import com.iamsajan.app.model.ShowSeat;
import com.iamsajan.app.repository.ShowSeatRepository;
import com.iamsajan.app.service.CinemaSeatService;
import com.iamsajan.app.service.ShowSeatService;
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
public class ShowSeatServiceImpl implements ShowSeatService {

    private final Logger log = LoggerFactory.getLogger(ShowSeatServiceImpl.class);
    private final ShowSeatRepository showSeatRepository;
    private final ShowService showService;
    private final BookingServiceImpl bookingService;
    private final CinemaSeatService cinemaSeatService;

    @Override
    public ShowSeatResponseDto createShowSeat(ShowSeatRequestDto showSeatRequestDto) {
        Show show;
        CinemaSeat cinemaSeat;
        Booking booking;

        log.info("Request to create show seat: {}", showSeatRequestDto);
        if (showSeatRequestDto == null) {
            log.warn("ShowSeatRequestDto cannot be null");
            throw new IllegalArgumentException("ShowSeatRequestDto cannot be null");
        }

        if (showSeatRequestDto.getShowId() == null) {
            log.warn("Show cannot be null");
            throw new IllegalArgumentException("Show cannot be null");
        } else {
            show = showService.findShowById(showSeatRequestDto.getShowId());
        }

        if (showSeatRequestDto.getBookingId() == null) {
            log.warn("Booking cannot be null");
            throw new IllegalArgumentException("Booking cannot be null");
        } else {
            booking = bookingService.findBookingById(showSeatRequestDto.getBookingId());
        }

        if (showSeatRequestDto.getCinemaSeatId() == null) {
            log.warn("CinemaSeat cannot be null");
            throw new IllegalArgumentException("CinemaSeat cannot be null");
        } else {
            cinemaSeat = cinemaSeatService.findCinemaById(showSeatRequestDto.getCinemaSeatId());
        }

        ShowSeat showSeat = new ShowSeat();
        showSeat.setId(UUID.randomUUID().toString());
        showSeat.setStatus(showSeatRequestDto.getStatus());
        showSeat.setPrice(showSeatRequestDto.getPrice());
        showSeat.setShow(show);
        showSeat.setBooking(booking);
        showSeat.setCinemaSeat(cinemaSeat);

        return showSeatResponseMapper(showSeatRepository.save(showSeat));
    }

    @Override
    public Page<ShowSeatResponseDto> getShowSeats(Pageable pageable) {
        log.info("Request to get show seat: {}", pageable);
        return showSeatRepository.findAll(pageable).map(this::showSeatResponseMapper); // map(showSeat -> showSeatResponseMapper(showSeat))
    }

    @Override
    public ShowSeatResponseDto updateShowSeat(ShowSeatRequestDto showSeatRequestDto) {
        Show show;
        CinemaSeat cinemaSeat;
        Booking booking;

        log.info("Request to create show seat: {}", showSeatRequestDto);

        if (showSeatRequestDto.getId() == null) {
            log.warn("Show Seat Id cannot be null");
            throw new IllegalArgumentException("Show Seat Id cannot be null");
        }

        if (showSeatRequestDto.getShowId() == null) {
            log.warn("Show cannot be null");
            throw new IllegalArgumentException("Show cannot be null");
        } else {
            show = showService.findShowById(showSeatRequestDto.getShowId());
        }

        if (showSeatRequestDto.getBookingId() == null) {
            log.warn("Booking cannot be null");
            throw new IllegalArgumentException("Booking cannot be null");
        } else {
            booking = bookingService.findBookingById(showSeatRequestDto.getBookingId());
        }

        if (showSeatRequestDto.getCinemaSeatId() == null) {
            log.warn("CinemaSeat cannot be null");
            throw new IllegalArgumentException("CinemaSeat cannot be null");
        } else {
            cinemaSeat = cinemaSeatService.findCinemaById(showSeatRequestDto.getCinemaSeatId());
        }

        ShowSeat showSeat = showSeatRepository.findById(showSeatRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("Show Seat not found"));

        showSeat.setStatus(showSeatRequestDto.getStatus());
        showSeat.setPrice(showSeatRequestDto.getPrice());
        showSeat.setShow(show);
        showSeat.setBooking(booking);
        showSeat.setCinemaSeat(cinemaSeat);

        return showSeatResponseMapper(showSeatRepository.save(showSeat));
    }

    @Override
    public void deleteShowSeat(String id) {
        log.info("Request to delete show seat: {}", id);
        if (id == null) {
            log.warn("Id cannot be null");
            throw new IllegalArgumentException("Id cannot be null");
        }
        showSeatRepository.deleteById(id);
    }

    private ShowSeatResponseDto showSeatResponseMapper(ShowSeat showSeat) {
        return ShowSeatResponseDto.builder()
                .Id(showSeat.getId())
                .status(showSeat.getStatus())
                .price(showSeat.getPrice())
                .show(showSeat.getShow())
                .booking(showSeat.getBooking())
                .cinemaSeat(showSeat.getCinemaSeat())
                .build();
    }
}
