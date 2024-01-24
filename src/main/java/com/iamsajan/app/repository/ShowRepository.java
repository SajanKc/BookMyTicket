package com.iamsajan.app.repository;

import com.iamsajan.app.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, String> {
}
