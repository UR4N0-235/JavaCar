package com.ur4n0.avaliacaobackendjava.business.carros.dto.GetAll.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarroDTO {
    private Long modelo_id;
    private int ano;
    private String combustivel;
    private int num_portas;
    private String cor;    
}
