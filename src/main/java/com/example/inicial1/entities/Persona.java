package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="persona")
@AllArgsConstructor
@NoArgsConstructor //constructor vacio
@Setter
@Getter
@Builder
@Audited
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;


    @OneToOne(cascade =CascadeType.PERSIST)
    @JoinColumn(name="fk_domicilio")
    private Domicilio domicilio;


}