package com.ur4n0.avaliacaobackendjava.business.carros;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ur4n0.avaliacaobackendjava.core.common.errors.IdNotFoundException;
import com.ur4n0.avaliacaobackendjava.core.interfaces.ServiceInterface;

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
    public CarroEntity getById(Long id){
        CarroEntity carro = carroRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found carro with id " + id)); 
        return carro;
    }

    @Override
    public CarroEntity create(CarroEntity entityToSave) {
        return carroRepository.save(entityToSave);
    }

    @Override
    public void delete(Long id){
        CarroEntity carro = carroRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found carro with ID " + id));
        carroRepository.delete(carro);
    }

    @Override
    public CarroEntity update(Long id, CarroEntity entityToUpdate) {
        CarroEntity carro = carroRepository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("Not found carro with ID " + id));

        carro.setAno(entityToUpdate.getAno());
        carro.setCombustivel(entityToUpdate.getCombustivel());
        carro.setCor(entityToUpdate.getCor());
        carro.setModelo_id(entityToUpdate.getModelo_id());
        carro.setNum_portas(entityToUpdate.getNum_portas());

        // Timestamp do cadastro não vai poder ser alterado!
        //carro.setTimestamp_cadastro(null); 

		return carroRepository.save(carro);
    }
}
