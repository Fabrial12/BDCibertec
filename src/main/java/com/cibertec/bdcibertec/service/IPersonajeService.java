package com.cibertec.bdcibertec.service;


import com.cibertec.bdcibertec.model.Personajes;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService {
    List<Personajes> findAll();
    Optional<Personajes> findById(int id);
    Personajes save(Personajes personajes);
    void deleteById(Integer id);
}
