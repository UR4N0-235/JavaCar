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

import com.ur4n0.avaliacaobackendjava.business.marcas.MarcaService;
import com.ur4n0.avaliacaobackendjava.business.modelos.dto.ModeloDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"/api/modelos", "/api/modelos/"})
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(modeloService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {
        ModeloEntity modelo = modeloService.getById(id);
        return new ResponseEntity<>(modelo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ModeloDTO modeloDTO) {
        ModeloEntity modelo = new ModeloEntity();
        modelo.setMarca_id(marcaService.getById(modeloDTO.getMarca_id()));
        modelo.setNome(modeloDTO.getNome());
        modelo.setValor_fipe(modeloDTO.getValor_fipe());

        modelo = modeloService.create(modelo);
        return new ResponseEntity<>(modelo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @Valid @RequestBody ModeloDTO modeloDTO) {
        ModeloEntity modelo = new ModeloEntity();
        modelo.setMarca_id(marcaService.getById(modeloDTO.getMarca_id()));
        modelo.setNome(modeloDTO.getNome());
        modelo.setValor_fipe(modeloDTO.getValor_fipe());
        
        modelo = modeloService.update(id, modelo);
        return new ResponseEntity<>(modelo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        modeloService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}