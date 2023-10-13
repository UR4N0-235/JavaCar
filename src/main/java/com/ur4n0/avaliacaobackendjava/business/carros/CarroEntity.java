package com.ur4n0.avaliacaobackendjava.business.carros;

import com.ur4n0.avaliacaobackendjava.business.modelos.ModeloEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CarroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "timestamp_cadastro", nullable = false)
    private Long timestamp_cadastro;
    
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloEntity modelo_id;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "combustivel", nullable = false)
    private String combustivel;

    @Column(name = "num_portas", nullable = false)
    private int num_portas;

    @Column(name = "cor", nullable = false)
    private String cor;
}