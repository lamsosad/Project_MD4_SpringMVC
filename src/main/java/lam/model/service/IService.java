package lam.model.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    boolean save(T t);
    boolean update(T t);
    T findById(int id);
    boolean delete(int id);
}

