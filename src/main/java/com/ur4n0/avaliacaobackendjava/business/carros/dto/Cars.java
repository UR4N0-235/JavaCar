package com.ur4n0.avaliacaobackendjava.business.carros.dto;

import com.ur4n0.avaliacaobackendjava.business.carros.CarroEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cars {
    Long id;
    Long timestamp_cadastro;
    Long modelo_id;
    int ano;
    String combustivel;
    int num_portas;
    String cor;
    String nome_modelo;
    double valor;

    public Cars(CarroEntity entity) {
        this.id = entity.getId();
        this.timestamp_cadastro = entity.getTimestamp_cadastro();
        this.modelo_id = entity.getModelo_id().getId();
        this.ano = entity.getAno();
        this.combustivel = entity.getCombustivel();
        this.num_portas = entity.getNum_portas();
        this.cor = entity.getCor();
        this.nome_modelo = entity.getModelo_id().getNome();
        this.valor = entity.getModelo_id().getValor_fipe();
    }    
    
}