package com.iamsajan.app.service;

import com.iamsajan.app.dto.request.CityRequestDto;
import com.iamsajan.app.dto.response.CityResponseDto;
import com.iamsajan.app.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CityService {

    CityResponseDto createCity(CityRequestDto cityRequestDto);

    Page<City> getAllCity(Pageable pageable);

    void deleteCity(String id);

    City updateCity(CityRequestDto cityRequestDto);
}
