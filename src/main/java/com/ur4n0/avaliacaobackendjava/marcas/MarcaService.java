package com.ur4n0.avaliacaobackendjava.marcas;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ur4n0.avaliacaobackendjava.Interfaces.ServiceInterface;

@Service
public class MarcaService implements ServiceInterface<MarcaEntity> {
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<MarcaEntity> getAll() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<MarcaEntity> getById(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public MarcaEntity save(MarcaEntity entityToSave) {
        return marcaRepository.save(entityToSave);
    }

    @Override
    public void delete(MarcaEntity entityToDelete) {
        if(marcaRepository.findById(entityToDelete.getId()).isPresent())
            marcaRepository.delete(entityToDelete);
    }
}
