package com.ur4n0.avaliacaobackendjava.marcas;

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

import com.ur4n0.avaliacaobackendjava.common.ResponseErrorMensage;

@RestController
@RequestMapping("/api/marcas/")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(marcaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {
        try {
            MarcaEntity marca = marcaService.getById(id);
            return new ResponseEntity<>(marca, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MarcaEntity entity) {
        try {
            MarcaEntity marca = marcaService.create(entity);
            return new ResponseEntity<>(marca, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody MarcaEntity entity) {
        try {
            MarcaEntity marca = marcaService.update(id, entity);
            return new ResponseEntity<>(marca, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        try {
            marcaService.delete(id);;
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception error) {
            return new ResponseEntity<>(new ResponseErrorMensage(error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
