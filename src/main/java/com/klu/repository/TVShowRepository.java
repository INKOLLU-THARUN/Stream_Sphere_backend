package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.TVShow;

public interface TVShowRepository extends JpaRepository<TVShow, Long> {
}
