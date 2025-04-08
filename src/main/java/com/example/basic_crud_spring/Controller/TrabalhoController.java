package com.example.basic_crud_spring.Controller;


import com.example.basic_crud_spring.Entity.Trabalho;
import com.example.basic_crud_spring.Service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @PostMapping
    public Trabalho create(@RequestBody Trabalho trabalho){
        return this.service.create(trabalho);
    }

    @GetMapping
    public List<Trabalho> read(){
        return this.service.read();
    }

    @GetMapping(value = "/{titulo}/{nota}")
    public List<Trabalho> findByTituloContainsAndNotaGreaterThan(@PathVariable("titulo") String titulo, @PathVariable("nota") Integer nota){
        return this.service.findByTituloContainsAndNotaGreaterThan(titulo, nota);
    }
}
