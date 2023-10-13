package com.ur4n0.avaliacaobackendjava.business.modelos;

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

import com.ur4n0.avaliacaobackendjava.core.common.ResponseErrorMensage;

@RestController
@RequestMapping("/api/modelos/")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(modeloService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {
        try {
            ModeloEntity modelo = modeloService.getById(id);
            return new ResponseEntity<>(modelo, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModeloEntity entity) {
        try {
            ModeloEntity modelo = modeloService.create(entity);
            return new ResponseEntity<>(modelo, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody ModeloEntity entity) {
        try {
            ModeloEntity modelo = modeloService.update(id, entity);
            return new ResponseEntity<>(modelo, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        try {
            modeloService.delete(id);;
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}