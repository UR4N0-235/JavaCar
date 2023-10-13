package com.ur4n0.avaliacaobackendjava.carros;

import java.util.List;

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
    public CarroEntity getById(Long id) throws Exception{
        CarroEntity carro = carroRepository.findById(id)
            .orElseThrow(() -> new Exception("Not found carro with id " + id)); 
        return carro;
    }

    @Override
    public CarroEntity create(CarroEntity entityToSave) throws Exception {
        if(carroRepository.findById(entityToSave.getId()).isPresent()) 
            throw new Exception("carro with this id already exists!");
        return carroRepository.save(entityToSave);
    }

    @Override
    public void delete(CarroEntity entityToDelete) throws Exception{
        CarroEntity carro = carroRepository.findById(entityToDelete.getId())
            .orElseThrow(() -> new Exception("Not found carro with ID " + entityToDelete.getId()));
        carroRepository.delete(carro);
    }

    @Override
    public CarroEntity update(Long id, CarroEntity entityToUpdate) throws Exception {
        CarroEntity carro = carroRepository.findById(id)
            .orElseThrow(() -> new Exception("Not found carro with ID " + id));

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
