package com.cibertec.bdcibertec.service;

import com.cibertec.bdcibertec.model.Personajes;
import com.cibertec.bdcibertec.model.ProgramaTv;

import java.util.List;

public interface IProgramaTvService {
    List<ProgramaTv> findAll();
    ProgramaTv findById(Integer id);
    ProgramaTv save(ProgramaTv programaTv);
    void deleteById(Integer id);
}
