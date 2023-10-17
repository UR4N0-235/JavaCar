package com.ur4n0.avaliacaobackendjava.business.modelos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ur4n0.avaliacaobackendjava.business.carros.CarroEntity;
import com.ur4n0.avaliacaobackendjava.business.marcas.MarcaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class ModeloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome; 

    @Column(name = "valor_fipe", nullable = false)
    private Double valor_fipe;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaEntity marca_id;

    @OneToMany(mappedBy = "modelo_id")
    @JsonIgnore
    private List<CarroEntity> carros = new ArrayList<>();
}
