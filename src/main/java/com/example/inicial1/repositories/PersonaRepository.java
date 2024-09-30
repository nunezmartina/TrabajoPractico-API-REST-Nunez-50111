package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    // Aquí puedes agregar métodos personalizados si es necesario

    //metodo de query para obtener un listado de personas de acuerdo a un filtro por su nombre o apellido
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //con paginacion
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);


    //con los metodos de query se pueden hacer verificaciones
    //boolean existsByDni(int dni); //para verificar si existe o no una persona con ese dni

    //misma consulta con anotacion query con JPQL
    //@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1%") //dentro de % ? y numero de parametros%
    //List<Persona> search(String filtro);

    //otra forma con parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro")String filtro);

    //con paginacion
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro")String filtro, Pageable pageable);

    //misma consulta pero con query SQL
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro")String filtro);

    //con paginacion
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count (*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro")String filtro, Pageable pageable);




}