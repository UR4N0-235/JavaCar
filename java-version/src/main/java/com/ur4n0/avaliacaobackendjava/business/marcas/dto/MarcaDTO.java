package com.ur4n0.avaliacaobackendjava.business.marcas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {
    @NotBlank
    String nome_marca;
}
