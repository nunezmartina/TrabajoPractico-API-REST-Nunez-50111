package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements BaseService <Localidad>{

    private LocalidadRepository localidadRepository;

    public LocalidadService(LocalidadRepository localidadRepository){
        this.localidadRepository=localidadRepository;
    }
    @Override
    @Transactional //Indica que estos métodos van a hacer transacciones con la bd
    public List<Localidad> findAll() throws Exception {
        try{
            List<Localidad> entities =localidadRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad findById(long id) throws Exception {
        try{
            Optional<Localidad> entityOptional =localidadRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try{
            entity =localidadRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(long id, Localidad entity) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            Localidad localidad= entityOptional.get();
            localidad =localidadRepository.save(entity);
            return localidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try{
            if(localidadRepository.existsById(id)){
                localidadRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}



