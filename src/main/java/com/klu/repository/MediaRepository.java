package com.klu.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.Media;
public interface MediaRepository extends JpaRepository<Media, Long> {
}
