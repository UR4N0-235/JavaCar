package com.ur4n0.avaliacaobackendjava.core.interfaces;

import java.util.List;

public interface ServiceInterface<T> {
    public List<T> getAll();
    public T getById(Long id);
    public T create(T entityToSave);
    public T update(Long id, T entityToUpdate);
    public void delete(Long id);
}
