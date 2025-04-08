package com.example.basic_crud_spring.Service;

import com.example.basic_crud_spring.Entity.Trabalho;
import com.example.basic_crud_spring.Repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repo;

    public Trabalho create(Trabalho trabalho){
        if(trabalho.getTitulo() == null || trabalho.getTitulo().isBlank()
                || trabalho.getGrupo() == null  || trabalho.getGrupo().isBlank()
        )throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta título ou grupo!");

        if (trabalho.getDataHoraEntrega() == null){
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }
        return this.repo.save(trabalho);
    }

    public List<Trabalho> read(){
        return this.repo.findAll();
    }

    public List<Trabalho> findByTituloContainsAndNotaGreaterThan(String titulo, Integer nota){
        return this.repo.findByTituloContainsAndNotaGreaterThan(titulo, nota);
    }
}
