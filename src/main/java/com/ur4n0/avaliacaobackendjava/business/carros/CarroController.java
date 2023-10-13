package com.ur4n0.avaliacaobackendjava.business.carros;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ur4n0.avaliacaobackendjava.business.carros.dto.GetAll.Cars;
import com.ur4n0.avaliacaobackendjava.business.carros.dto.GetAll.GetAllResponse;
import com.ur4n0.avaliacaobackendjava.business.carros.dto.GetAll.requestEntity.CarroDTO;
import com.ur4n0.avaliacaobackendjava.business.modelos.ModeloEntity;
import com.ur4n0.avaliacaobackendjava.business.modelos.ModeloService;
import com.ur4n0.avaliacaobackendjava.core.common.ResponseErrorMensage;

@RestController
@RequestMapping("/api/carros/")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Cars> carsDTO = new ArrayList<>();

        carroService.getAll().forEach((carro) -> {
            carsDTO.add(new Cars(carro));
        });

        return new ResponseEntity<>(new GetAllResponse(carsDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {
        try {
            CarroEntity carro = carroService.getById(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CarroDTO carroDTO) {
        try {
            ModeloEntity modelo = modeloService.getById(carroDTO.getModelo_id());
            CarroEntity carro = new CarroEntity();
            carro.setTimestamp_cadastro(System.currentTimeMillis()/1000);
            carro.setAno(carroDTO.getAno());
            carro.setCombustivel(carroDTO.getCombustivel());
            carro.setCor(carroDTO.getCor());
            carro.setModelo_id(modelo);
            carro.setNum_portas(carroDTO.getNum_portas());

            carro = carroService.create(carro); // só para recuperar o id criado.
            
            return new ResponseEntity<>(carro, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody CarroEntity entity) {
        try {
            CarroEntity carro = carroService.update(id, entity);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        try {
            carroService.delete(id);;
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}