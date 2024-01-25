package com.iamsajan.app.service.impl;

import com.iamsajan.app.constant.Status;
import com.iamsajan.app.dto.request.BookingRequestDto;
import com.iamsajan.app.dto.response.BookingResponseDto;
import com.iamsajan.app.model.Booking;
import com.iamsajan.app.model.Customer;
import com.iamsajan.app.model.Show;
import com.iamsajan.app.repository.BookingRepository;
import com.iamsajan.app.service.BookingService;
import com.iamsajan.app.service.CustomerService;
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
public class BookingServiceImpl implements BookingService {

    private final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final ShowService showService;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        Customer customer;
        Show show;
        log.info("createBooking: {}", bookingRequestDto);
        if (bookingRequestDto == null) {
            log.info("bookingRequestDto cannot be null");
            throw new IllegalArgumentException("bookingRequestDto cannot be null");
        }

        if (bookingRequestDto.getCustomerId() == null) {
            log.info("customerId cannot be null");
            throw new IllegalArgumentException("customerId cannot be null");
        } else {
            customer = customerService.findCustomerById(bookingRequestDto.getCustomerId());
        }

        if (bookingRequestDto.getShowId() == null) {
            log.info("showId cannot be null");
            throw new IllegalArgumentException("showId cannot be null");
        } else {
            show = showService.findShowById(bookingRequestDto.getShowId());
        }

        Booking booking = new Booking();
        booking.setId(UUID.randomUUID().toString());
        booking.setTimestamp(bookingRequestDto.getTimestamp());
        booking.setStatus(bookingRequestDto.getStatus());
        booking.setCustomer(customer);
        booking.setShow(show);

        return bookingResponseMapper(bookingRepository.save(booking));
    }

    private BookingResponseDto bookingResponseMapper(Booking booking) {
        return BookingResponseDto.builder()
                .id(booking.getId())
                .timestamp(booking.getTimestamp().toString())
                .status(Status.values()[booking.getStatus()].name()) // int -> enum -> string
                .customer(booking.getCustomer())
                .show(booking.getShow())
                .build();
    }

    @Override
    public Page<BookingResponseDto> getBooking(Pageable pageable) {
        return bookingRepository.findAll(pageable).map(this::bookingResponseMapper); // booking -> bookingResponseMapper(booking)
    }

    @Override
    public BookingResponseDto updateBooking(BookingRequestDto bookingRequestDto) {
        Customer customer;
        Show show;
        log.info("createBooking: {}", bookingRequestDto);
        if (bookingRequestDto == null) {
            log.info("bookingRequestDto cannot be null");
            throw new IllegalArgumentException("bookingRequestDto cannot be null");
        }

        if (bookingRequestDto.getId() == null) {
            log.info("bookingId cannot be null");
            throw new IllegalArgumentException("bookingId cannot be null");
        }

        Booking booking = bookingRepository.findById(bookingRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("Booking not found !!!"));

        if (bookingRequestDto.getCustomerId() == null) {
            log.info("customerId cannot be null");
            throw new IllegalArgumentException("customerId cannot be null");
        } else {
            customer = customerService.findCustomerById(bookingRequestDto.getCustomerId());
        }

        if (bookingRequestDto.getShowId() == null) {
            log.info("showId cannot be null");
            throw new IllegalArgumentException("showId cannot be null");
        } else {
            show = showService.findShowById(bookingRequestDto.getShowId());
        }

        booking.setTimestamp(bookingRequestDto.getTimestamp());
        booking.setStatus(bookingRequestDto.getStatus());
        booking.setCustomer(customer);
        booking.setShow(show);

        return bookingResponseMapper(bookingRepository.save(booking));
    }

    @Override
    public void deleteBooking(String id) {
        log.info("Deleting booking with id {}", id);
        if (id == null) {
            log.warn("Booking id cannot be null !!!");
            throw new RuntimeException("Booking id cannot be null !!!");
        }
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking findBookingById(String bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found !!!"));
    }
}
