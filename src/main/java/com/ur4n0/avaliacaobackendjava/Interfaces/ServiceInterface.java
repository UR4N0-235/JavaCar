package com.ur4n0.avaliacaobackendjava.Interfaces;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {
    public List<T> getAll();
    public Optional<T> getById(Long id);
    public T save(T entityToSave); // create & update
    public void delete(T entityToDelete);
}
