package com.ur4n0.avaliacaobackendjava.business.modelos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModeloDTO {
    @NotBlank
    String nome;

    @NotNull
    Double valor_fipe;

    @NotNull
    Long marca_id;
}
