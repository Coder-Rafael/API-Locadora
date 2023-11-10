package com.apiLocadora.APILocadora.Repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apiLocadora.APILocadora.Models.CarModel;



public interface CarRepository extends JpaRepository<CarModel, UUID> {
    @Query("SELECT c FROM CAR_MODEL c WHERE c.nome LIKE :nome%")
    Page<CarModel> findByNome(@Param("nome") String nome, Pageable pageable);
}
