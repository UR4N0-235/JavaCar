package com.ur4n0.avaliacaobackendjava.marcas;

import java.util.List;

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
    public MarcaEntity getById(Long id) throws Exception{
        MarcaEntity marca = marcaRepository.findById(id)
            .orElseThrow(() -> new Exception("Not found marca with id " + id)); 
        return marca;
    }

    @Override
    public MarcaEntity create(MarcaEntity entityToSave) throws Exception {
        if(marcaRepository.findById(entityToSave.getId()).isPresent()) 
            throw new Exception("marca with this id already exists!");
        return marcaRepository.save(entityToSave);
    }

    @Override
    public void delete(MarcaEntity entityToDelete) throws Exception{
        MarcaEntity marca = marcaRepository.findById(entityToDelete.getId())
            .orElseThrow(() -> new Exception("Not found marca with ID " + entityToDelete.getId()));
        marcaRepository.delete(marca);
    }

    @Override
    public MarcaEntity update(Long id, MarcaEntity entityToUpdate) throws Exception {
        MarcaEntity marca = marcaRepository.findById(id)
            .orElseThrow(() -> new Exception("Not found marca with ID " + id));

        marca.setNome_marca(entityToUpdate.getNome_marca());
		return marcaRepository.save(marca);
    }
}
