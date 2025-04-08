package com.example.basic_crud_spring.Repository;

import com.example.basic_crud_spring.Entity.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    @Query("Select t " +
            "from Trabalho t " +
            "where t.titulo like %?1% and t.nota > ?2")
    List<Trabalho> findByTituloContainsAndNotaGreaterThan(String titulo, Integer nota);
}
