package com.ur4n0.avaliacaobackendjava.business.carros;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ur4n0.avaliacaobackendjava.business.carros.dto.requestEntity.CarroDTO;
import com.ur4n0.avaliacaobackendjava.business.carros.dto.responseToGetAll.Car;
import com.ur4n0.avaliacaobackendjava.business.carros.dto.responseToGetAll.GetAllResponse;
import com.ur4n0.avaliacaobackendjava.business.modelos.ModeloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carros/")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Car> carsDTO = new ArrayList<>();

        carroService.getAll().forEach((carro) -> {
            carsDTO.add(new Car(carro));
        });

        return new ResponseEntity<>(new GetAllResponse(carsDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {
        CarroEntity carro = carroService.getById(id);
        return new ResponseEntity<>(carro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CarroDTO carroDTO) {
        CarroEntity carro = new CarroEntity();
        carro.setTimestamp_cadastro(System.currentTimeMillis() / 1000);
        carro.setAno(carroDTO.getAno());
        carro.setCombustivel(carroDTO.getCombustivel());
        carro.setCor(carroDTO.getCor());
        carro.setModelo_id(modeloService.getById(carroDTO.getModelo_id()));
        carro.setNum_portas(carroDTO.getNum_portas());

        carro = carroService.create(carro); // só para recuperar o id criado.

        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @Valid @RequestBody CarroDTO carroDTO) {
        CarroEntity carro = new CarroEntity();
        carro.setAno(carroDTO.getAno());
        carro.setCombustivel(carroDTO.getCombustivel());
        carro.setCor(carroDTO.getCor());
        carro.setModelo_id(modeloService.getById(carroDTO.getModelo_id()));
        carro.setNum_portas(carroDTO.getNum_portas());

        carro = carroService.update(id, carro);
        return new ResponseEntity<>(carro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        carroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}