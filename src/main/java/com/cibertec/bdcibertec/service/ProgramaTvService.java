package com.cibertec.bdcibertec.service;

import com.cibertec.bdcibertec.model.Personajes;
import com.cibertec.bdcibertec.model.ProgramaTv;
import com.cibertec.bdcibertec.repository.ProgramaTvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProgramaTvService implements IProgramaTvService {
    private final ProgramaTvRepository programaTvRepository;

    @Override
    public List<ProgramaTv> findAll() {
        return programaTvRepository.findAll();
    }

    @Override
    public ProgramaTv findById(Integer id) {
        return programaTvRepository.findById(id).orElse(null);
    }

    @Override
    public ProgramaTv save(ProgramaTv programaTv) {
        return programaTvRepository.save(programaTv);
    }

    @Override
    public void deleteById(Integer id) {
        programaTvRepository.deleteById(id);
    }
}
