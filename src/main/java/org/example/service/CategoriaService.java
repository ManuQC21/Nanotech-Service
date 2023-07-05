package org.example.service;

import org.example.repository.CategoriaRepository;
import org.example.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.example.utils.Global.*;

@Service
@Transactional
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }
    public GenericResponse listarCategoriasActivas(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listarCategoriasActivas());
    }
}