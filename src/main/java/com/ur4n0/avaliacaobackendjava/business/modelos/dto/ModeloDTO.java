package com.ur4n0.avaliacaobackendjava.business.modelos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModeloDTO {
    String nome;
    Double valor_fipe;
    Long marca_id;   
}
