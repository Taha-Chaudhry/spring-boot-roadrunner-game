package com.roadrunner.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roadrunner.app.model.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long>{
    
}