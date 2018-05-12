package com.selcukuzunsoy.ders1.com.uzunsoy.dao;

import java.util.List;

public interface BaseDao<T> {

    public boolean create(T nesne);

    public T read(int id);

    public boolean update(T nesne);

    public boolean delete(int id);

    public List<T> readAll(Integer count, Integer start);

}
