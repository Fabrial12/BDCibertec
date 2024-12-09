package com.cibertec.bdcibertec.controller;

import com.cibertec.bdcibertec.model.ProgramaTv;
import com.cibertec.bdcibertec.service.ProgramaTvService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/programatv")
public class ProgramaTvController {
    @Autowired
    private ProgramaTvService programaTvService;

    @GetMapping
    public List<ProgramaTv> getAll() {
        return programaTvService.findAll();
    }

    @GetMapping("/{id}")
    public ProgramaTv getById(@PathVariable Integer id) {
        return programaTvService.findById(id);
    }

    @PostMapping
    public ProgramaTv create(@RequestBody ProgramaTv programaTv) {
        return programaTvService.save(programaTv);
    }

    @PutMapping("/{id}")
    public ProgramaTv update(@PathVariable Integer id, @RequestBody ProgramaTv programaTv) {
        programaTv.setIdProgramaTv(id);
        return programaTvService.save(programaTv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        programaTvService.deleteById(id);
    }
}
