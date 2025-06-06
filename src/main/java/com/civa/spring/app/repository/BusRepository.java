package com.civa.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civa.spring.app.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}
