package com.ur4n0.avaliacaobackendjava.core.interfaces;

import java.util.List;

public interface ServiceInterface<T> {
    public List<T> getAll();
    public T getById(Long id) throws Exception;
    public T create(T entityToSave) throws Exception;
    public T update(Long id, T entityToUpdate) throws Exception;
    public void delete(Long id) throws Exception;
}
