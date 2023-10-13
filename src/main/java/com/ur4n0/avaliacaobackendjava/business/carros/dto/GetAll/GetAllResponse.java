package com.ur4n0.avaliacaobackendjava.business.carros.dto.GetAll;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllResponse {
    List<Cars> cars;
}