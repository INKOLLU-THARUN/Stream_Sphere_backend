package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.klu.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@NonNull
	List<Movie> findAll();
}
