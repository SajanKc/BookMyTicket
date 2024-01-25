package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.request.CinemaSeatRequestDto;
import com.iamsajan.app.dto.response.CinemaSeatResponseDto;
import com.iamsajan.app.model.CinemaHall;
import com.iamsajan.app.model.CinemaSeat;
import com.iamsajan.app.repository.CinemaSeatRepository;
import com.iamsajan.app.service.CinemaHallService;
import com.iamsajan.app.service.CinemaSeatService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CinemaSeatServiceImpl implements CinemaSeatService {

    private final Logger log = LoggerFactory.getLogger(CinemaSeatServiceImpl.class);
    private final CinemaSeatRepository cinemaSeatRepository;
    private final CinemaHallService cinemaHallService;

    @Override
    public CinemaSeatResponseDto createCinemaSeat(CinemaSeatRequestDto cinemaSeatRequestDto) {
        CinemaHall cinemaHall;
        log.info("createCinemaSeat() called with cinemaSeatRequestDto = [" + cinemaSeatRequestDto + "]");
        if (cinemaSeatRequestDto == null) {
            log.warn("CinemaSeatRequestDto cannot be null");
            throw new RuntimeException("CinemaSeatRequestDto cannot be null");
        }

        if (cinemaSeatRequestDto.getCinemaHallId() == null) {
            log.warn("CinemaHallId cannot be null");
            throw new RuntimeException("CinemaHallId cannot be null");
        } else {
            cinemaHall = cinemaHallService.findCinemaHallById(cinemaSeatRequestDto.getCinemaHallId());
        }

        CinemaSeat cinemaSeat = new CinemaSeat();
        cinemaSeat.setId(UUID.randomUUID().toString());
        cinemaSeat.setSeatNumber(cinemaSeatRequestDto.getSeatNumber());
        cinemaSeat.setType(cinemaSeatRequestDto.getType());
        cinemaSeat.setCinemaHall(cinemaHall);

        return cinemaSeatResponseMapper(cinemaSeatRepository.save(cinemaSeat));
    }

    @Override
    public Page<CinemaSeatRequestDto> getAllCinemaSeat(Pageable pageable) {
        log.info("getAllCinemaSeat() called with pageable.");
        return cinemaSeatRepository.findAll(pageable).map(
                cinemaSeat -> CinemaSeatRequestDto.builder()
                        .id(cinemaSeat.getId())
                        .seatNumber(cinemaSeat.getSeatNumber())
                        .type(cinemaSeat.getType())
                        .cinemaHallId(cinemaSeat.getCinemaHall().getId())
                        .build()
        );
    }

    @Override
    public CinemaSeatResponseDto updateCinemaSeat(CinemaSeatRequestDto cinemaSeatRequestDto) {
        log.info("updateCinemaSeat() called with cinemaSeatRequestDto = [" + cinemaSeatRequestDto + "]");
        if (cinemaSeatRequestDto == null) {
            log.warn("CinemaSeatRequestDto cannot be null");
            throw new RuntimeException("CinemaSeatRequestDto cannot be null");
        }

        if (cinemaSeatRequestDto.getCinemaHallId() == null) {
            log.warn("CinemaHallId cannot be null");
            throw new RuntimeException("CinemaHallId cannot be null");
        }

        CinemaSeat cinemaSeat = cinemaSeatRepository.findById(cinemaSeatRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("CinemaSeat not found"));
        cinemaSeat.setSeatNumber(cinemaSeatRequestDto.getSeatNumber());
        cinemaSeat.setType(cinemaSeatRequestDto.getType());
        cinemaSeat.setCinemaHall(cinemaHallService.findCinemaHallById(cinemaSeatRequestDto.getCinemaHallId()));

        return cinemaSeatResponseMapper(cinemaSeatRepository.save(cinemaSeat));
    }

    @Override
    public void deleteCinemaSeat(String id) {
        log.info("deleteCinemaSeat() called with id = [" + id + "]");
        if (id == null)
            throw new RuntimeException("Id cannot be null");
        cinemaSeatRepository.deleteById(id);
    }

    @Override
    public CinemaSeat findCinemaById(String cinemaSeatId) {
        return cinemaSeatRepository.findById(cinemaSeatId)
                .orElseThrow(() -> new RuntimeException("CinemaSeat not found"));
    }

    private CinemaSeatResponseDto cinemaSeatResponseMapper(CinemaSeat CinemaSeat) {
        return CinemaSeatResponseDto.builder()
                .id(CinemaSeat.getId())
                .seatNumber(CinemaSeat.getSeatNumber())
                .type(CinemaSeat.getType())
                .cinemaHallId(CinemaSeat.getCinemaHall().getId())
                .build();
    }

}
