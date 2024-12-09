package com.cibertec.bdcibertec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ProgramaTv")
public class ProgramaTv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProgramaTv;
    private String titulo;
    private String resumen;
    private LocalDate fechaInicio;
    @ManyToOne
    @JoinColumn(name = "idPersonaje")
    private Personajes personaje;
}
