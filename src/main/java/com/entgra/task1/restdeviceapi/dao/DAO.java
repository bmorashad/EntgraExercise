package com.entgra.task1.restdeviceapi.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> findById(long id);
    List<T> findAll();
    boolean save(T t);
    Optional<T> updateById(T t);
    boolean deleteById(long id);
}
