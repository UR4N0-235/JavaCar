package com.ur4n0.avaliacaobackendjava.business.modelos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ur4n0.avaliacaobackendjava.core.common.errors.IdNotFoundException;
import com.ur4n0.avaliacaobackendjava.core.interfaces.ServiceInterface;

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
    public ModeloEntity getById(Long id){
        ModeloEntity modelo = modeloRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found modelo with id " + id)); 
        return modelo;
    }

    @Override
    public ModeloEntity create(ModeloEntity entityToSave) {
        return modeloRepository.save(entityToSave);
    }

    @Override
    public void delete(Long id){
        ModeloEntity modelo = modeloRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found modelo with ID " + id));
        modeloRepository.delete(modelo);
    }

    @Override
    public ModeloEntity update(Long id, ModeloEntity entityToUpdate) {
        ModeloEntity modelo = modeloRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found modelo with ID " + id));

        modelo.setMarca_id(entityToUpdate.getMarca_id());
        modelo.setNome(entityToUpdate.getNome());
        modelo.setValor_fipe(entityToUpdate.getValor_fipe());

		return modeloRepository.save(modelo);
    }
}
