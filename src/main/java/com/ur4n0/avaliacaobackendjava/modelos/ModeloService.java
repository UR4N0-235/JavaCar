package com.ur4n0.avaliacaobackendjava.modelos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ur4n0.avaliacaobackendjava.Interfaces.ServiceInterface;

@Service
public class ModeloService implements ServiceInterface<ModeloEntity> {
    private final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @Override
    public List<ModeloEntity> getAll() {
        return modeloRepository.findAll();
    }

    @Override
    public Optional<ModeloEntity> getById(Long id) {
        return modeloRepository.findById(id);
    }

    @Override
    public ModeloEntity save(ModeloEntity entityToSave) {
        return modeloRepository.save(entityToSave);
    }

    @Override
    public void delete(ModeloEntity entityToDelete) {
        if(modeloRepository.findById(entityToDelete.getId()).isPresent())
            modeloRepository.delete(entityToDelete);
    }
}
