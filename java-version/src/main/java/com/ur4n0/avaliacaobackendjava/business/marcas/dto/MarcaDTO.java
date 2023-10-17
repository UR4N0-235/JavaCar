package com.ur4n0.avaliacaobackendjava.business.marcas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MarcaDTO {
    @NotBlank
    String nome_marca;
}
