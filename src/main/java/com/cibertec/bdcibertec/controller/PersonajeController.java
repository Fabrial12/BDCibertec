package com.cibertec.bdcibertec.controller;

import com.cibertec.bdcibertec.model.Personajes;
import com.cibertec.bdcibertec.service.PersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/personaje")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<Personajes> getAll() {
        return personajeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Personajes> getById(@PathVariable Integer id) {
        return personajeService.findById(id);
    }

    @PostMapping
    public Personajes create(@RequestBody Personajes personaje) {
        return personajeService.save(personaje);
    }

    @PutMapping("/{id}")
    public Personajes update(@PathVariable Integer id, @RequestBody Personajes personaje) {
        personaje.setIdPersonaje(id);
        return personajeService.save(personaje);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        personajeService.deleteById(id);
    }
}
