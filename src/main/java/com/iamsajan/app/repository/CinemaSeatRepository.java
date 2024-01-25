package com.iamsajan.app.repository;

import com.iamsajan.app.model.CinemaSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaSeatRepository extends JpaRepository<CinemaSeat, String> {
}
