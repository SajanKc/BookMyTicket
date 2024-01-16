package com.iamsajan.app.controller;

import com.iamsajan.app.dto.request.CityRequestDto;
import com.iamsajan.app.dto.response.CityResponseDto;
import com.iamsajan.app.model.City;
import com.iamsajan.app.service.CityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final Logger log = LoggerFactory.getLogger(CityController.class);

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities(Pageable pageable) {
        log.info("Request to get all cities with pagination {}", pageable);
        Page<City> cityList = cityService.getAllCity(pageable);
        return ResponseEntity.ok().body(cityList.getContent());
    }

    @PostMapping("/create")
    public ResponseEntity<CityResponseDto> createCity(@RequestBody CityRequestDto cityRequestDto) {
        log.info("Request to create city {}", cityRequestDto);
        CityResponseDto cityResponseDto = cityService.createCity(cityRequestDto);
        return ResponseEntity.ok().body(cityResponseDto);
    }

    @PutMapping("/update")
    public ResponseEntity<CityResponseDto> updateCity(@RequestBody CityRequestDto cityRequestDto) {
        log.info("Request to update city {}", cityRequestDto);
        CityResponseDto updatedCity = cityService.updateCity(cityRequestDto);
        return ResponseEntity.ok().body(updatedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") String id) {
        log.info("Request to delete city {}", id);
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
