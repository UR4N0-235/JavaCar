package com.ur4n0.avaliacaobackendjava.business.carros.dto.requestEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarroDTO {
    @NotNull
    private Long modelo_id;

    @NotNull
    private Integer ano;

    @NotBlank
    private String combustivel;

    @NotNull
    private Integer num_portas;

    @NotBlank
    private String cor;
}
