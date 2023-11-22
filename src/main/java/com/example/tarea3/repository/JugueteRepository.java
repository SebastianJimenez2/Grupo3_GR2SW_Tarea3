package com.example.tarea3.repository;

import com.example.tarea3.model.JuguetesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugueteRepository extends JpaRepository<JuguetesEntity, Long> {

}






