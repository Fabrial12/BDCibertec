package com.cibertec.bdcibertec.service;

import org.springframework.web.multipart.MultipartFile;

import java.lang.Exception;

public interface IFileService {
    void guardarArchivo(MultipartFile file)
            throws Exception;
    void guardarArchivos(MultipartFile file)
            throws Exception;
}
