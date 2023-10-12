package com.ur4n0.avaliacaobackendjava.carros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroEntity, Long>  {
    
}
