package com.ur4n0.avaliacaobackendjava.business.marcas;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ur4n0.avaliacaobackendjava.core.common.errors.IdNotFoundException;
import com.ur4n0.avaliacaobackendjava.core.interfaces.ServiceInterface;

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
    public MarcaEntity getById(Long id){
        MarcaEntity marca = marcaRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found marca with id " + id)); 
        return marca;
    }

    @Override
    public MarcaEntity create(MarcaEntity entityToSave) {
        return marcaRepository.save(entityToSave);
    }

    @Override
    public void delete(Long id){
        MarcaEntity marca = marcaRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found marca with ID " + id));
        marcaRepository.delete(marca);
    }

    @Override
    public MarcaEntity update(Long id, MarcaEntity entityToUpdate) {
        MarcaEntity marca = marcaRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found marca with ID " + id));

        marca.setNome_marca(entityToUpdate.getNome_marca());
		return marcaRepository.save(marca);
    }
}
