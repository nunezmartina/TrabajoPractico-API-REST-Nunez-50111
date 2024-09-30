package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicesImpl extends BaseServiceImplementation<Persona, Long> implements PersonaService {

    @Autowired //cumple la misma funcion que el constructor
    private PersonaRepository personaRepository; //para poder acceder desde este repositorio a todos los metodos

    public PersonaServicesImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }

    //implementacion del metodo search
    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);

            //QUERY CON JPQL
            //List<Persona> personas = personaRepository.search(filtro);

            //QUERY CON SQL
            List<Persona> personas = personaRepository.searchNativo(filtro);


            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //con paginacion
    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try{
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);

            //QUERY CON JPQL
            //Page<Persona> personas = personaRepository.search(filtro, pageable);

            //QUERY CON SQL
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);

            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}