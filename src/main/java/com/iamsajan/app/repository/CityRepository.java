package com.iamsajan.app.repository;

import com.iamsajan.app.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}
