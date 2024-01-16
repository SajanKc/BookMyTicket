package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.request.CityRequestDto;
import com.iamsajan.app.dto.response.CityResponseDto;
import com.iamsajan.app.model.City;
import com.iamsajan.app.repository.CityRepository;
import com.iamsajan.app.service.CityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    private final CityRepository cityRepository;

    @Override
    public CityResponseDto createCity(CityRequestDto cityRequestDto) {
        log.info("Request to create city {}", cityRequestDto);
        if (cityRequestDto == null) {
            log.warn("City request cannot be null !!!");
            throw new RuntimeException("City request cannot be null !!!");
        }

        City city = new City();
        city.setName(cityRequestDto.getName());
        city.setState(cityRequestDto.getState());
        city.setZipCode(cityRequestDto.getZipCode());

        City savedCity = cityRepository.save(city);
        log.info("City created {}", savedCity);

        return cityResponseMapper(savedCity);
    }

    @Override
    public Page<City> getAllCity(Pageable pageable) {
        log.debug("Request to get all cities");
        return cityRepository.findAll(pageable);
    }

    @Override
    public void deleteCity(String id) {
        log.warn("Request to delete city {}", id);
        cityRepository.deleteById(id);
    }

    @Override
    public CityResponseDto updateCity(CityRequestDto cityRequestDto) {
        log.info("Request to update city {}", cityRequestDto);
        if (cityRequestDto.getId() == null) {
            log.warn("City id cannot be null !!!");
            throw new RuntimeException("City id cannot be null !!!");
        }
        City city = cityRepository.findById(cityRequestDto.getId()).orElseThrow(() -> new RuntimeException("City not found !!!"));
        // update old city data with new city data
        city.setName(cityRequestDto.getName());
        city.setState(cityRequestDto.getState());
        city.setZipCode(cityRequestDto.getZipCode());

        City savedCity = cityRepository.save(city);
        log.info("City updated {}", savedCity);

        return cityResponseMapper(savedCity);
    }

    @Override
    public City findById(String cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found !!!"));
    }

    public CityResponseDto cityResponseMapper(City city) {
        return CityResponseDto.builder()
                .id(city.getId())
                .name(city.getName())
                .state(city.getState())
                .zipCode(city.getZipCode())
                .build();
    }
}