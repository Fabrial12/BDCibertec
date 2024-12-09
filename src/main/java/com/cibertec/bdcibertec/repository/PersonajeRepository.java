package com.cibertec.bdcibertec.repository;

import com.cibertec.bdcibertec.model.Personajes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<Personajes, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Personaje SET nomPersonaje=:nomPersonaje " +
            "WHERE idPersonaje=:idPersonaje",
            nativeQuery = true)
    void actualizarNombrePersonaje(
            @Param("idPersonaje") Integer idPersonaje,
            @Param("nomPersonaje") String nomPersonaje);
}
