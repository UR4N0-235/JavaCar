package com.ur4n0.avaliacaobackendjava.business.marcas;

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

import com.ur4n0.avaliacaobackendjava.business.marcas.dto.MarcaDTO;

import jakarta.validation.Valid;

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
        MarcaEntity marca = marcaService.getById(id);
        return new ResponseEntity<>(marca, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody MarcaDTO marcaDTO) {
        MarcaEntity marca = new MarcaEntity();
        marca.setNome_marca(marcaDTO.getNome_marca());

        marca = marcaService.create(marca);
        return new ResponseEntity<>(marca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @Valid @RequestBody MarcaDTO marcaDTO) {
        MarcaEntity marca = new MarcaEntity();
        marca.setNome_marca(marcaDTO.getNome_marca());

        marca = marcaService.update(id, marca);
        return new ResponseEntity<>(marca, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        marcaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
