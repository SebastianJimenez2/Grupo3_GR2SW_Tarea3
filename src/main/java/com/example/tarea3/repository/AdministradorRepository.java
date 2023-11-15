package com.example.tarea3.repository;

import com.example.tarea3.model.AdministradoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministradorRepository extends JpaRepository<AdministradoresEntity, Long> {
}

