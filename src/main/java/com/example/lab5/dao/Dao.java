package com.example.lab5.dao;

import java.io.Serializable;
import java.util.List;


public interface Dao<T, ID extends Serializable> {
    T get(ID id);
    List<T> getAll();
    void save(T entity);
    void delete(ID id);
    void update(T updated);
}
