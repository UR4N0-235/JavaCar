package com.ur4n0.avaliacaobackendjava.marcas;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ur4n0.avaliacaobackendjava.modelos.ModeloEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class MarcaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome_marca", nullable = false)
    private String nome_marca;

    @OneToMany(mappedBy = "marca_id")
    @JsonIgnore
    private List<ModeloEntity> modelos = new ArrayList<>();
}
