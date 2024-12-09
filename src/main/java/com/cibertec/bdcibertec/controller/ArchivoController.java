package com.cibertec.bdcibertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/archivos")
public class ArchivoController {
    private static final List<String> EXTENSIONES_VALIDAS = Arrays.asList("pdf", "png", "docx");

    @PostMapping("/multiples")
    public ResponseEntity<String> subirArchivos(@RequestParam("archivos") MultipartFile[] archivos) {
        if (archivos.length > 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se permiten como máximo 3 archivos.");
        }

        for (MultipartFile archivo : archivos) {
            String extension = obtenerExtension(archivo.getOriginalFilename());
            if (!EXTENSIONES_VALIDAS.contains(extension)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Extensión no permitida: " + extension);
            }
        }

        return ResponseEntity.ok("Archivos subidos exitosamente.");
    }

    private String obtenerExtension(String nombreArchivo) {
        return nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();
    }
    @PostMapping("/unico")
    public ResponseEntity<String> subirArchivo(@RequestParam("archivo") MultipartFile archivo) {
        if (archivo.getSize() > 25 * 1024 * 1024) { // 25MB
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo supera el tamaño máximo permitido de 25MB.");
        }

        String extension = obtenerExtension(archivo.getOriginalFilename());
        if (!EXTENSIONES_VALIDAS.contains(extension)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Extensión no permitida: " + extension);
        }

        return ResponseEntity.ok("Archivo subido exitosamente.");
    }
}
