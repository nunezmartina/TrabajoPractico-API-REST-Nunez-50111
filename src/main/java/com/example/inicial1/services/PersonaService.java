package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona,Long> {
    //creamos la estructura de los metodos
    List<Persona> search(String filtro) throws Exception;

    //search con paginacion
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
