package com.ur4n0.avaliacaobackendjava.carros;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ur4n0.avaliacaobackendjava.Interfaces.ServiceInterface;

@Service
public class CarroService implements ServiceInterface<CarroEntity> {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public List<CarroEntity> getAll() {
        return carroRepository.findAll();
    }

    @Override
    public Optional<CarroEntity> getById(Long id) {
        return carroRepository.findById(id);
    }

    @Override
    public CarroEntity save(CarroEntity entityToSave) {
        return carroRepository.save(entityToSave);
    }

    @Override
    public void delete(CarroEntity entityToDelete) {
        if(carroRepository.findById(entityToDelete.getId()).isPresent())
            carroRepository.delete(entityToDelete);
    }
}
