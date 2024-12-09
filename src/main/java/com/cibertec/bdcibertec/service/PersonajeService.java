package com.cibertec.bdcibertec.service;

import com.cibertec.bdcibertec.model.Personajes;
import com.cibertec.bdcibertec.repository.PersonajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonajeService implements IPersonajeService{

    private final PersonajeRepository personajeRepository;

    @Override
    public List<Personajes> findAll() {
        return personajeRepository.findAll();
    }

    @Override
    public Optional<Personajes> findById(int id) {
        return personajeRepository.findById(id);
    }

    @Override
    public Personajes save(Personajes personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public void deleteById(Integer id) {
        personajeRepository.deleteById(id);
    }

}
